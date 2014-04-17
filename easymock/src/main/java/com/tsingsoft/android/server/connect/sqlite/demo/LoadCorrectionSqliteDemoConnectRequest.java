package com.tsingsoft.android.server.connect.sqlite.demo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;

import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tsingsoft.android.entity.LfCtrlNet;
import com.tsingsoft.android.entity.LoadCharacter;
import com.tsingsoft.android.entity.LoadCorrection;
import com.tsingsoft.android.entity.db.dao.LoadCorrectionDao;
import com.tsingsoft.android.server.connect.http.HttpConnectRequest;
import com.tsingsoft.android.server.connect.sqlite.demo.helper.LoadCorrectionHelper;
import com.tsingsoft.android.server.exception.SearchException;
import com.tsingsoft.android.server.search.ServerSearch;
import com.tsingsoft.android.server.search.ServerSearchCondition;
import com.tsingsoft.android.util.ColumnUtil;
import com.tsingsoft.android.util.LoadCharactUtil;
import com.tsingsoft.android.util.StringUtil;



/**
 * <pre>
 * 负荷修改 - 
 * </pre>
 * 
 * @author wt
 * @time 2014-02-25
 */
public class LoadCorrectionSqliteDemoConnectRequest  extends HttpConnectRequest {

	@SuppressWarnings("unchecked")
	public <T> T search(ServerSearch<T> search, Context context)throws SearchException {
		
	
		ServerSearchCondition condition = search.buildSearchCondition();
		List<NameValuePair> pairList = condition.getPairList();
		Map<String,String> map=new HashMap<String,String>();
		for(NameValuePair pnv:pairList){
			map.put(pnv.getName(),pnv.getValue());
		}
		LoadCorrectionHelper help=new LoadCorrectionHelper();
		Object result =help.process(map,context);
		return (T) buildClientEntity(result,context);
	}
	
	private LoadCorrection buildClientEntity(Object obj,Context context) {
		JSONObject json = assertReturnData(obj);
		LoadCorrection load = new LoadCorrection();
		// 参考负荷
		load.setHisLoadList(getDoubleListArr(json, "referenceLoad"));
		// 预测负荷
		List<Double> forecastList = getDoubleList(json, "forecastLoad");
		load.setForecastLoadList(forecastList);
		// 预测日期
		load.setForecastDate(getStringJSONObject(json, "forecastDate"));
		// 参考日期
		load.setReferenceDate(getStringJSONObject(json, "referenceDate"));
		// 默认参考日期列表
		load.setDefaultRefDate(getDefaultRefDate(json,"referenceDateStr"));
		// 口径
		load.setCaliberId(getStringJSONObject(json, "caliberId"));
		// 查询类型
		load.setType(getStringJSONObject(json, "type"));
		// 电网信息
		load.setNet(getNet(json, "net"));
		load.setSysCurDate(getStringJSONObject(json, "sysCurrentTime"));
		
		// 入库负荷预测表（用于还原）
		LoadCorrectionDao dao = new LoadCorrectionDao(context);
		if(load.getForecastLoadList()!=null && !load.getForecastLoadList().isEmpty()){
			dao.insertCorrection(load);
		}
		
		// 如果预测曲线是通过上报查询的，则取本地库
		if("1".equals(load.getType())){
			List<Double> _load = dao.getFcSubmit(load.getNet().getNetId(),load.getCaliberId(), load.getForecastDate());
			if(_load!=null && !_load.isEmpty()){
				load.setForecastLoadList(_load);
			}
		}
		List<Double> list = load.getForecastLoadList();
		List<Double> _forecastList = new ArrayList<Double>();
		DecimalFormat df = new DecimalFormat("########0.00"); 
 		for(Double dou : list){
			Double d = dou;
			if(dou!=null){
				d = Double.parseDouble(df.format(d));
			}
			_forecastList.add(d);
		}
		load.setForecastLoadList(_forecastList);
		// 负荷特性
		load.setLoadCharacter(getLoadCharacter(_forecastList));
		return load;
	}
	
	
	private LoadCharacter getLoadCharacter(List<Double> list){
		if(list.isEmpty()){
			return null;
		}
		DecimalFormat df = new DecimalFormat("########0.00");
		LoadCharacter loadCharacter = new LoadCharacter();
		Double max = LoadCharactUtil.maxLoad(list);
		String maxTime = "";
		Double min = LoadCharactUtil.minLoad(list);
		String minTime = "";
		Double avg = LoadCharactUtil.avgLoad(list);
		Double difference = LoadCharactUtil.difference(list);
		Double loadRate = LoadCharactUtil.loadRate(list);
		Double differenceRate = LoadCharactUtil.differenceRate(list);
		
		String[] columns = ColumnUtil.DAY_LOAD_CURVE_96COLUMN;
		
		for(int i= 0; i<list.size(); i++){
			if(list.get(i)==max){
				maxTime = columns[i].substring(1, 3) + ":" + columns[i].substring(3, 5);
			}
			if(list.get(i)==min){
				minTime = columns[i].substring(1, 3) + ":" + columns[i].substring(3, 5);
			}
		}
		String _max = max==null?"":df.format(max);
		loadCharacter.setMaxLoad(_max);
		loadCharacter.setMaxLoadTime(maxTime);
		String _min = min == null?"":df.format(min);
		loadCharacter.setMinLoad(_min);
		loadCharacter.setMinLoadTime(minTime);
		String _avg = avg==null?"":df.format(avg);
		loadCharacter.setAvgLoad(_avg);
		String _difference = difference==null?"":df.format(difference);
		loadCharacter.setDifference(_difference);
		String _loadRate = loadRate == null?"":df.format(loadRate);
		loadCharacter.setLoadRate(_loadRate);
		String _differenceRate = differenceRate==null?"":df.format(differenceRate);
		loadCharacter.setDifferenceRate(_differenceRate);
		return loadCharacter;

	}
	
	private LfCtrlNet getNet(JSONObject object, String key){
		LfCtrlNet result = new LfCtrlNet();
		Object value = object.get(key);
		if (StringUtil.isEmpty(value)) {
			return result;
		}
		if (value instanceof JSONArray) {
			JSONArray valueArray = (JSONArray) value;
			int i=0;
			for (Object obj : valueArray) {
				String v = obj==null?"":obj.toString();
				if(i==0){
					result.setNetId(v);
				}else{
					result.setNetName(v);
				}
				i++;
			}
		}
		return result;
	}
	
	private List<String> getDefaultRefDate(JSONObject object,String key){
		List<String> result = new ArrayList<String>();
		Object value = object.get(key);
		if (StringUtil.isEmpty(value)) {
			return result;
		}
		String[] arr = value.toString().split(",");
		for(int i =0; i<arr.length; i++){
			result.add(arr[i]);
		}
		return result;
	}
}
