/*
 * WeatherSqliteDemoHelper.java
 * Copyright: Copyright TsingSoft (c) 2014
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.connect.sqlite.demo.helper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import com.tsingsoft.android.common.SysConstant;
import com.tsingsoft.android.data.demo.SqliteDemoDataConstants;
import com.tsingsoft.android.entity.StFactorMaplib;
import com.tsingsoft.android.entity.db.dao.StFactorMaplibDao;
import com.tsingsoft.android.entity.db.dao.StHisFactorDao;
import com.tsingsoft.android.server.search.ServerSearchCondition;
import com.tsingsoft.android.util.DateUtil;
import com.tsingsoft.android.util.StringUtil;

/**
 * <pre>
 * 天气信息 - demo使用Sqlite - 处理数据逻辑
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月26日
 */
public class WeatherSqliteDemoHelper extends BaseSliteDemoHelper {

	/** 当前系统时间 */
	private Date curDate;
	/** 当前系统时间(日期格式yyyyMMdd，周几格式为:星期几) */
	private TimeEntity curTime;
	/** 历史时间(日期格式yyyyMMdd，周几格式为:周几) */
	private List<TimeEntity> hisTime;
	/** 未来时间(日期格式yyyyMMdd，周几格式为:周几) */
	private List<TimeEntity> futureTime;
	/** 查询数据的日期 */
	private List<String> ymdList;
	/** 相关因素映射库信息 */
	private List<StFactorMaplib> mapLibList;

	private static String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
	private static String[] weekDays2 = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };

	public WeatherSqliteDemoHelper(ServerSearchCondition condition, Context context) {
		this.context = context;
		initParam(condition);
	}

	public String getResult() {
		TreeMap<String, Object> result = new TreeMap<String, Object>();
		try {
			mapLibList = getMapLibList();
			// 气象数据
			TreeMap<String, TreeMap<String, Double>> weatherDataMap = getFactorData();
			// 设置当前日期的气象数据
			result.put("curWeather", getCurWeatherDataMap(weatherDataMap));
			// 设置历史日期的气象数据
			result.put("hisWeather", getOtherWeatherDataList(hisTime, weatherDataMap));
			// 设置未来日期的气象数据
			result.put("futuerWeather", getOtherWeatherDataList(futureTime, weatherDataMap));
		} catch (Exception e) {
			e.printStackTrace();
			result.put(SysConstant.ERROR_MESSAGE, "获取数据失败");
		}
		String jsonStr = JSONArray.toJSONString(result);
		return jsonStr;
	}

	/**
	 * 获取相关因素映射库信息
	 * 
	 * @return
	 * @throws Exception
	 */
	private List<StFactorMaplib> getMapLibList() {
		StFactorMaplibDao dao = new StFactorMaplibDao(context);
		return dao.findAll();
	}

	/**
	 * <pre>
	 * 获取气象数据
	 * key:日期（格式yyyyMMdd）;value:(key:factorId,value:气象值)
	 * </pre>
	 */
	private TreeMap<String, TreeMap<String, Double>> getFactorData() {
		StHisFactorDao dao = new StHisFactorDao(context);
		return dao.getFactorsValue(ymdList, netId);
	}

	/**
	 * 获取当前时间的气象数据
	 * 
	 * @return
	 */
	private Map<String, String> getCurWeatherDataMap(
			TreeMap<String, TreeMap<String, Double>> weatherDataMap) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("ymd", DateUtil.formatDate(curDate, "yyyy/MM/dd"));
		result.put("weekDay", curTime.getWeekDay());
		Map<String, Double> weatherData = weatherDataMap.get(curTime.getYmd());
		// 平均温度
		String tempreture = getFactorValue(weatherData, "1");
		result.put("tempreture", tempreture);
		// 天气类型
		result.put("weatherType", getWeatherType(weatherData));
		// 风向
		Double windDirectionValue = weatherData.get("7");
		result.put("windDirection", getStFactorMaplib("7", windDirectionValue));
		// 风力
		Double windPowerValue = weatherData.get("6");
		result.put("windPower", getStFactorMaplib("6", windPowerValue));
		// 湿度
		String humidity = getFactorValue(weatherData, "8");
		if (!StringUtil.isEmpty(humidity)) {
			humidity += "%";
		}
		result.put("humidity", humidity);
		return result;
	}

	/**
	 * 获取某个气象类型的数据
	 * 
	 * @param weatherDataMap
	 * @param facotrId
	 * @return
	 */
	private String getFactorValue(Map<String, Double> weatherDataMap, String facotrId) {
		if (weatherDataMap == null || weatherDataMap.isEmpty()) {
			return "";
		}
		Double result = weatherDataMap.get(facotrId);
		return numberFormatValue(result);
	}

	/**
	 * 获取天气类型
	 * 
	 * @param weatherData
	 * @return
	 */
	private String getWeatherType(Map<String, Double> weatherData) {
		Double weatherTypeValue = weatherData.get("5");
		return getStFactorMaplib("5", weatherTypeValue);
	}

	/**
	 * 获取相关因素映射库信息
	 * 
	 * @param factorId
	 * @param beforeValue
	 * @return
	 */
	private String getStFactorMaplib(String factorId, Double beforeValue) {
		String result = "";
		if (beforeValue == null) {
			return result;
		}
		for (StFactorMaplib mapLib : mapLibList) {
			if (!factorId.equals(mapLib.getFactorId())) {
				continue;
			}
			if (beforeValue.doubleValue() == mapLib.getBeforeValue().doubleValue()) {
				result = mapLib.getItemName();
				break;
			}
		}
		return result;
	}

	/**
	 * 获取其他时间的气象数据
	 * 
	 * @return
	 */
	private List<Map<String, String>> getOtherWeatherDataList(List<TimeEntity> timeEntityList,
			TreeMap<String, TreeMap<String, Double>> weatherDataMap) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		for (TimeEntity timeEntity : timeEntityList) {
			Map<String, String> map = new HashMap<String, String>();
			String ymd = timeEntity.getYmd();
			// 设置时间
			map.put("ymd", formatMMdd(ymd));
			map.put("weekDay", timeEntity.getWeekDay());
			Map<String, Double> weatherData = weatherDataMap.get(ymd);
			// 设置天气类型
			String weatherType = getWeatherType(weatherData);
			map.put("weatherType", weatherType);
			// 设置温度
			StringBuilder value = new StringBuilder();
			// 最低温度
			String minTempreture = getFactorValue(weatherData, "3");
			// 最高温度
			String maxTempreture = getFactorValue(weatherData, "2");
			if (!StringUtil.isEmpty(minTempreture) || !StringUtil.isEmpty(maxTempreture)) {
				if (StringUtil.isEmpty(minTempreture)) {
					minTempreture = "-- ";
				}
				if (StringUtil.isEmpty(maxTempreture)) {
					maxTempreture = " --";
				}
				value.append(minTempreture).append("~").append(maxTempreture).append("℃");
			}
			map.put("tempreture", value.toString().trim());
			result.add(map);
		}
		return result;
	}

	/**
	 * 初始化参数
	 */
	private void initParam(ServerSearchCondition condition) {
		curDate = SqliteDemoDataConstants.getDefaultCurDate();

		ymdList = new LinkedList<String>();
		netId = getParameterValue("netId", condition);

		curTime = new TimeEntity();
		curTime.setYmd(formatDate(curDate));
		curTime.setWeekDay(getWeekOfDay(curDate, weekDays));

		ymdList.add(curTime.getYmd());

		hisTime = buildTimeEntityList(curDate, false);
		futureTime = buildTimeEntityList(curDate, true);
	}

	/**
	 * 获取周几的信息
	 * 
	 * @param date
	 * @param weekDays
	 * @return
	 */
	private String getWeekOfDay(Date date, String[] weekDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/**
	 * 构造TimeEntity集合
	 * 
	 * @param date
	 *            ：日期
	 * @param forward
	 *            ：true，未来3天；false：历史3天
	 * @return
	 */
	private List<TimeEntity> buildTimeEntityList(Date date, boolean forward) {
		List<TimeEntity> result = new LinkedList<TimeEntity>();
		int addDay = 1;
		if (!forward) {
			addDay = -1;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		for (int i = 0; i < 3; i++) {
			cal.add(Calendar.DAY_OF_MONTH, addDay);
			Date nextDate = cal.getTime();
			TimeEntity timeEntity = new TimeEntity();
			timeEntity.setYmd(formatDate(nextDate));
			timeEntity.setWeekDay(getWeekOfDay(nextDate, weekDays2));
			if (forward) {
				result.add(timeEntity);
			} else {
				result.add(0, timeEntity);
			}
			ymdList.add(timeEntity.getYmd());
		}
		return result;
	}

	/**
	 * 格式化日期 （yyyyMMdd）
	 * 
	 * @param date
	 * @return
	 */
	private String formatDate(Date date) {
		return DateUtil.formatDate(date, "yyyyMMdd");
	}

	/**
	 * yyyyMMdd格式的日期转成MM月dd日
	 * 
	 * @param ymd
	 * @return
	 */
	private String formatMMdd(String ymd) {
		try {
			Date date = DateUtil.parseDate(ymd);
			return DateUtil.formatDate(date, "MM月dd日");
		} catch (Exception e) {
		}
		return ymd;
	}

}
