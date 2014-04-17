/*
 * LoadAnalyzeSqliteDemoConnectRequest.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.connect.sqlite.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tsingsoft.android.entity.LoadAnalyze;
import com.tsingsoft.android.entity.LoadCharacter;
import com.tsingsoft.android.server.connect.http.HttpConnectRequest;
import com.tsingsoft.android.server.connect.sqlite.demo.helper.LoadAnalyzeSqliteDemoHelper;
import com.tsingsoft.android.server.exception.SearchException;
import com.tsingsoft.android.server.search.ServerSearch;
import com.tsingsoft.android.server.search.ServerSearchCondition;
import com.tsingsoft.android.util.DateUtil;

/**
 * <pre>
 * 负荷分析 - demo使用Sqlite - 连接服务器端的请求
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月26日
 */
public class LoadAnalyzeSqliteDemoConnectRequest extends HttpConnectRequest {

	@SuppressWarnings("unchecked")
	public <T> T search(ServerSearch<T> search, Context context) throws SearchException {
		ServerSearchCondition condition = search.buildSearchCondition();
		LoadAnalyzeSqliteDemoHelper helper = new LoadAnalyzeSqliteDemoHelper(condition, context);
		String result = helper.getResult();
		return (T) buildClientEntity(result);
	}

	private LoadAnalyze buildClientEntity(Object obj) {
		JSONObject json = assertReturnData(obj);
		LoadAnalyze loadAnalyze = new LoadAnalyze();
		// 服务器系统当前时间
		loadAnalyze.setCurHourMinute(getStringJSONObject(json, "curHourMinute"));
		loadAnalyze.setCurYmd(getStringJSONObject(json, "curYmd"));
		// 当前日期的负荷特性
		loadAnalyze.setCurLoadCharacter(buildCurLoadCharacter(json));
		// 负荷特性列表
		loadAnalyze.setYmdloadCharacterList(buildYmdloadCharacterList(json));
		// 负荷时刻点
		loadAnalyze.setPointTimeList(getStringList(json, "pointTimeList"));
		// 历史负荷
		TreeMap<String, List<Double>> hisLoadMap = buildHisLoadMap(json);
		loadAnalyze.setHisLoadMap(hisLoadMap);
		// 查询的负荷日期集合
		loadAnalyze.setSearchYmdList(buildSearchYmdList(hisLoadMap));
		return loadAnalyze;
	}

	/**
	 * 构造查询的负荷日期集合（格式yyyyMMdd）
	 */
	private List<String> buildSearchYmdList(TreeMap<String, List<Double>> hisLoadMap) {
		List<String> result = new ArrayList<String>();
		try {
			for (String key : hisLoadMap.keySet()) {
				Date date = DateUtil.parse(key, "yyyy年MM月dd日");
				result.add(DateUtil.formatYYYYMMDD(date));
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 构造历史负荷
	 * 
	 * @return
	 */
	private TreeMap<String, List<Double>> buildHisLoadMap(JSONObject json) {
		TreeMap<String, List<Double>> result = new TreeMap<String, List<Double>>();
		JSONArray array = json.getJSONArray("ymdLoad");
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonObject = (JSONObject) array.get(i);
			String ymd = getStringJSONObject(jsonObject, "ymd");
			List<Double> loadList = getDoubleList(jsonObject, "data");
			result.put(ymd, loadList);
		}
		return result;
	}

	/**
	 * 构造负荷特性列表
	 * 
	 * @param json
	 * @return
	 */
	private List<LoadCharacter> buildYmdloadCharacterList(JSONObject json) {
		JSONArray array = json.getJSONArray("ymdLoadCharacter");
		List<LoadCharacter> result = new ArrayList<LoadCharacter>();
		for (int i = 0; i < array.size(); i++) {
			JSONObject object = (JSONObject) array.get(i);
			result.add(buildLoadCharacter(object));
		}
		return result;
	}

	/**
	 * 当前日期的负荷特性
	 */
	private LoadCharacter buildCurLoadCharacter(JSONObject json) {
		JSONObject jsonObject = json.getJSONObject("curLoadCharacter");
		return buildLoadCharacter(jsonObject);
	}

	/**
	 * 构造负荷特性
	 * 
	 * @param loadCharacterJsonObject
	 * @return
	 */
	private LoadCharacter buildLoadCharacter(JSONObject loadCharacterJsonObject) {
		LoadCharacter result = new LoadCharacter();
		result.setMaxLoad(loadCharacterJsonObject.getString("maxLoad"));
		result.setMinLoad(loadCharacterJsonObject.getString("minLoad"));
		result.setAvgLoad(loadCharacterJsonObject.getString("avgLoad"));
		result.setLoadRate(loadCharacterJsonObject.getString("loadRate"));
		result.setDifference(loadCharacterJsonObject.getString("difference"));
		result.setDifferenceRate(loadCharacterJsonObject.getString("differenceRate"));
		result.setYmd(loadCharacterJsonObject.getString("ymd"));
		return result;
	}
}
