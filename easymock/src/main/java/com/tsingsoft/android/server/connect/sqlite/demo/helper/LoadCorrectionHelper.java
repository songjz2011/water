package com.tsingsoft.android.server.connect.sqlite.demo.helper;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.tsingsoft.android.data.demo.SqliteDemoDataConstants;
import com.tsingsoft.android.entity.LfCtrlNet;
import com.tsingsoft.android.entity.LfHis96Lc;
import com.tsingsoft.android.entity.StFc96LcSubmit;
import com.tsingsoft.android.entity.db.dao.LfCtrlNetDao;
import com.tsingsoft.android.entity.db.dao.LfHis96LcDao;
import com.tsingsoft.android.entity.db.dao.StFc96LcSubmitDao;
import com.tsingsoft.android.util.DateUtil;

/**
 * 负荷修正控制器
 * 
 * @author wt
 * @time 2013-12-18
 */
public class LoadCorrectionHelper {
	Context context;
	/** 电网ID */
	protected String netId;

	/** 口径ID */
	protected String caliberId;
	/**
	 * 预测日期 (查询条件)
	 */
	private String forecastDate;

	/**
	 * 参考日期
	 */
	private String referenceDate;

	/**
	 * 用于查询的参考日期数组
	 */
	private String[] referenceDateArr;

	private String referenceDateStr;

	/**
	 * 查询地区
	 */
	private String queryNetID;

	private LfCtrlNet net;

	/**
	 * 口径
	 */
	private String caliberID;



	public String process(Map<String, String> request,Context context) {
        this.context=context;
		TreeMap<String, Object> result = new TreeMap<String, Object>();
		try {
			initPara(request);
			LfCtrlNetDao netService = new LfCtrlNetDao(context);
			
				net = netService.findNetByNetId(queryNetID);
			
			List<List<Object>> referenceList = getReferenceLoad();
			// 参考负荷
			result.put("referenceLoad", referenceList);
			// 预测负荷
			List<Object> forecastLoadList = getForecastLoad();
			result.put("forecastLoad", forecastLoadList);
			// 预测日期
			result.put("forecastDate", forecastDate);
			// 参考日期
			result.put("referenceDate", referenceDate);
			result.put("referenceDateStr", referenceDateStr);
			// 电网信息
			result.put("net", getNetMsg());
			result.put("caliberId", caliberID);

			String datetime = DateUtil.formatDate(SqliteDemoDataConstants.getDefaultCurDate(), "yyyyMMdd HH:mm");
			result.put("sysCurrentTime", datetime);
			result.put("type", request.get("type"));

		} catch (Exception e) {
			//result.put(SysConstant.ERROR_MESSAGE, "获取数据失败");
		}
		return JSON.toJSONString(result);
	}

	/**
	 * 初始化参数
	 * 
	 * @throws UnsupportedEncodingException
	 */
	private void initPara(Map<String, String> request)
			throws UnsupportedEncodingException {
		forecastDate = request.get("forecastDate");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		if (forecastDate == null || "".equals(forecastDate)) {
			
			forecastDate = format.format(SqliteDemoDataConstants.getDefaultCurDate());
		
		}
		String _reference = request.get("referenceDateStr");
		if (_reference == null || "".equals(_reference)) {
			referenceDateArr = new String[2];
			referenceDateArr[0] = DateUtil.getMoveDay(forecastDate, -3,
					"yyyyMMdd");
			referenceDateArr[1] = DateUtil.getMoveDay(forecastDate, -2,
					"yyyyMMdd");
			StringBuilder sb = new StringBuilder();
			sb.append(referenceDateArr[0]).append(",")
					.append(referenceDateArr[1]);
			referenceDateStr = sb.toString();
		} else {
			referenceDateArr = _reference.split(",");
			referenceDateStr = _reference;
		}
		queryNetID = request.get("queryNetID");
		caliberID = request.get("caliberId");
		referenceDate = request.get("referenceDate");
		
	}

	/**
	 * 获取参考负荷曲线 如果参考日期是空的则默认查询预测日期前两日数据 如果有参考日期，则返回参考日期曲线
	 * 
	 * @return
	 * @throws Exception
	 */
	private List<List<Object>> getReferenceLoad() throws Exception {
		List<List<Object>> result = new ArrayList<List<Object>>();
		if (referenceDateArr.length == 0) {
			return result;
		}
		List<String> loadYmdList = new ArrayList<String>();
		for (int i = 0; i < referenceDateArr.length; i++) {
			loadYmdList.add(referenceDateArr[i]);
		}
		/*LfHis96LcService service = (LfHis96LcService) new LfHis96LcServiceImp(context);*/
		LfHis96LcDao service = new LfHis96LcDao(context);
		for (String ymd : loadYmdList) {
			LfHis96Lc lfHis96Lc = service.getDataByDay(queryNetID, caliberID,
					ymd);
			TreeMap<String, Double> dataMap = new TreeMap<String, Double>();
			if (lfHis96Lc != null) {
				dataMap = lfHis96Lc.getData();
			}
			List<Object> hisCurr = new ArrayList<Object>();
			if (dataMap != null && !dataMap.isEmpty()) {
				Iterator<Entry<String, Double>> it = dataMap.entrySet()
						.iterator();
				while (it.hasNext()) {
					Entry<String, Double> e = it.next();
					//Object value = SysUtil.getNumberFormat(2).format(e.getValue());
					Object value = e.getValue();
					hisCurr.add(value);
				}

			}
			result.add(hisCurr);
		}
		service=null;
		return result;
	}

	/**
	 * 获取预测负荷曲线数据
	 * 
	 * @return
	 * @throws Exception
	 */
	private List<Object> getForecastLoad() throws Exception {
		List<Object> result = new ArrayList<Object>();
		//StFc96LcSubmitService service = (StFc96LcSubmitService) new StFc96LcSubmitServiceImp(context);
		
		StFc96LcSubmitDao service =  new StFc96LcSubmitDao(context);
		List<StFc96LcSubmit> submitList = service.getFcSubmitLoadCurve(
				queryNetID, caliberID, forecastDate);

		TreeMap<String, Double> dataMap = new TreeMap<String, Double>();
		for (StFc96LcSubmit submit : submitList) {
			dataMap = submit.getPoints();
			break;
		}
		Iterator<Entry<String, Double>> itra = dataMap.entrySet().iterator();
		while (itra.hasNext()) {
			Entry<String, Double> e = itra.next();
			//Object value =SysUtil.getNumberFormat(2).format(e.getValue());
			Object value =e.getValue();
			result.add(value);
		}
		service=null;
		return result;
	}

	/**
	 * 获取电网信息
	 * 
	 * @throws Exception
	 */
	private List<Object> getNetMsg() throws Exception {
		List<Object> result = new ArrayList<Object>();
		result.add(queryNetID);
		result.add(net.getNetName());
		
		return result;
	}

}
