/*
 * LoadAnalyzeDemoHelper.java
 * Copyright: Copyright TsingSoft (c) 2014
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.connect.sqlite.demo.helper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import com.tsingsoft.android.common.SysConstant;
import com.tsingsoft.android.data.demo.SqliteDemoDataConstants;
import com.tsingsoft.android.entity.LfHis96Lc;
import com.tsingsoft.android.entity.db.dao.LfHis96LcDao;
import com.tsingsoft.android.server.search.ServerSearchCondition;
import com.tsingsoft.android.util.DateUtil;
import com.tsingsoft.android.util.LoadCharactUtil;
import com.tsingsoft.android.util.PointLoadHandleUtil;
import com.tsingsoft.android.util.StringUtil;

/**
 * <pre>
 * 负荷分析 - demo使用Sqlite - 处理数据逻辑
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月26日
 */
public class LoadAnalyzeSqliteDemoHelper extends BaseSliteDemoHelper {

	/** 当前系统时间 */
	private Date curDate;
	/** 当前系统时间的yyyyMMdd格式 */
	private String curYmd;
	/** 获取负荷的日期集合（格式yyyyMMdd） */
	private List<String> loadYmdList;

	public LoadAnalyzeSqliteDemoHelper(ServerSearchCondition condition, Context context) {
		this.context = context;
		initParam(condition);
	}

	public String getResult() {
		TreeMap<String, Object> result = new TreeMap<String, Object>();
		try {
			TreeMap<String, LfHis96Lc> hisLoadMap = getHisLoad();
			// 设置系统当前时间
			result.put("curYmd", DateUtil.formatDate(curDate, "yyyy.MM.dd"));
			result.put("curHourMinute", DateUtil.formatDate(curDate, "HH:mm"));
			// 设置当前时间的负荷特性
			List<Double> curloadList = getYmdHisLoadValueList(curYmd, hisLoadMap);
			result.put("curLoadCharacter", getLoadCharacter(curloadList));
			// 设置查询日期的负荷特性
			result.put("ymdLoadCharacter", getYmdLoadCharacter(hisLoadMap));
			// 设置负荷时刻点
			result.put("pointTimeList", getPointTimeList());
			// 设置历史负荷
			result.put("ymdLoad", getYmdLoad(hisLoadMap));
		} catch (Exception e) {
			e.printStackTrace();
			result.put(SysConstant.ERROR_MESSAGE, "获取数据失败");
		}
		String jsonStr = JSONArray.toJSONString(result);
		return jsonStr;
	}

	/**
	 * 获取历史负荷
	 * 
	 * @return
	 * @throws Exception
	 */
	private TreeMap<String, LfHis96Lc> getHisLoad() throws Exception {
		LfHis96LcDao dao = new LfHis96LcDao(context);
		// 增加当前日期，用于计算当前日期的负荷特性
		List<String> list = new LinkedList<String>();
		list.addAll(loadYmdList);
		if (!list.contains(curYmd)) {
			list.add(curYmd);
		}
		return dao.getDatas(netId, caliberId, list);
	}

	/**
	 * 获取日期的历史负荷值集合
	 * 
	 * @param ymd
	 * @param hisLoadMap
	 * @return
	 */
	private List<Double> getYmdHisLoadValueList(String ymd, TreeMap<String, LfHis96Lc> hisLoadMap) {
		List<Double> loadList = null;
		LfHis96Lc lfHis96Lc = hisLoadMap.get(ymd);
		if (lfHis96Lc != null) {
			loadList = new LinkedList<Double>();
			TreeMap<String, Double> loadDataMap = lfHis96Lc.getData();
			for (Entry<String, Double> entry : loadDataMap.entrySet()) {
				loadList.add(entry.getValue());
			}
		}
		return loadList;
	}

	/**
	 * 获取负荷特性,key：负荷特性的标志，value：负荷特性的值
	 */
	private Map<String, String> getLoadCharacter(List<Double> loadList) {
		Map<String, String> result = new HashMap<String, String>();
		// 最大负荷
		result.put("maxLoad", numberFormatValue(LoadCharactUtil.maxLoad(loadList)));
		// 最小负荷
		result.put("minLoad", numberFormatValue(LoadCharactUtil.minLoad(loadList)));
		// 平均负荷
		result.put("avgLoad", numberFormatValue(LoadCharactUtil.avgLoad(loadList)));
		// 负荷率
		String loadRate = numberFormatValue(LoadCharactUtil.loadRate(loadList));
		if (!StringUtil.isEmpty(loadRate)) {
			loadRate += "%";
		}
		result.put("loadRate", loadRate);
		// 峰谷差
		result.put("difference", numberFormatValue(LoadCharactUtil.difference(loadList)));
		// 峰谷差率
		String differenceRate = numberFormatValue(LoadCharactUtil.differenceRate(loadList));
		if (!StringUtil.isEmpty(differenceRate)) {
			differenceRate += "%";
		}
		result.put("differenceRate", differenceRate);
		return result;
	}

	/**
	 * 获取查询负荷日期的负荷特性 key：日期(格式：yyyy年MM月dd日)，value：（key：负荷特性的标志，value：负荷特性的值）
	 */
	private List<Map<String, String>> getYmdLoadCharacter(TreeMap<String, LfHis96Lc> hisLoadMap) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		for (String ymd : loadYmdList) {
			List<Double> loadList = getYmdHisLoadValueList(ymd, hisLoadMap);
			Map<String, String> map = getLoadCharacter(loadList);
			map.put("ymd", formatYmd(ymd));
			result.add(map);
		}
		return result;
	}

	/**
	 * yyyyMMdd格式的日期转成yyyy年MM月dd日
	 * 
	 * @param ymd
	 * @return
	 */
	private String formatYmd(String ymd) {
		try {
			Date date = DateUtil.parseDate(ymd);
			return DateUtil.formatDate(date, "yyyy年MM月dd日");
		} catch (Exception e) {
		}
		return ymd;
	}

	/**
	 * 负荷时刻点，转成00:15格式的结果
	 */
	private List<Object> getPointTimeList() {
		String[] dayLoad96 = SysConstant.DAY_LOAD_CURVE_96COLUMN;
		List<Object> result = new ArrayList<Object>();
		for (String point : dayLoad96) {
			result.add(PointLoadHandleUtil.convertPointTimeKey(point));
		}
		return result;
	}

	/**
	 * 获取查询日期的负荷 key：日期(格式：yyyy年MM月dd日)，value：（负荷值）
	 * 
	 * @param hisLoadMap
	 * @return
	 */
	private List<Map<String, Object>> getYmdLoad(TreeMap<String, LfHis96Lc> hisLoadMap) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (String ymd : loadYmdList) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Double> loadList = getYmdHisLoadValueList(ymd, hisLoadMap);
			List<String> list = null;
			if (loadList == null || loadList.isEmpty()) {
				list = PointLoadHandleUtil.buildEmpty96PointValueList();
			} else {
				list = new ArrayList<String>();
				for (Double value : loadList) {
					list.add(numberFormatValue(value));
				}
			}
			map.put("ymd", formatYmd(ymd));
			map.put("data", list);
			result.add(map);
		}
		return result;
	}

	/**
	 * 初始化参数
	 * 
	 * @throws UnsupportedEncodingException
	 */
	private void initParam(ServerSearchCondition condition) {
		curDate = SqliteDemoDataConstants.getDefaultCurDate();
		curYmd = DateUtil.formatDate(curDate, "yyyyMMdd");
		netId = getParameterValue("netId", condition);
		caliberId = getParameterValue("caliberId", condition);
		String loadYmds = getParameterValue("loadYmds", condition);
		loadYmdList = new LinkedList<String>();
		if (StringUtil.isEmpty(loadYmds)) {
			loadYmdList.add(curYmd);
		} else {
			// 日期排序
			TreeMap<String, String> map = new TreeMap<String, String>();
			String[] loadYmdArray = loadYmds.split(",");
			for (String str : loadYmdArray) {
				map.put(str, "");
			}
			for (String key : map.keySet()) {
				loadYmdList.add(key);
			}
		}
	}
}
