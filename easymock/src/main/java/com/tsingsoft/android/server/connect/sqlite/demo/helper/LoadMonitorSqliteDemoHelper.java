/*
 * LoadMonitorHelper.java
 * Copyright: Copyright TsingSoft (c) 2014
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.connect.sqlite.demo.helper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import com.tsingsoft.android.common.SysConstant;
import com.tsingsoft.android.data.demo.SqliteDemoDataConstants;
import com.tsingsoft.android.entity.LfHis96Lc;
import com.tsingsoft.android.entity.StFc96LcSubmit;
import com.tsingsoft.android.entity.db.dao.LfHis96LcDao;
import com.tsingsoft.android.entity.db.dao.StFc96LcSubmitDao;
import com.tsingsoft.android.server.search.ServerSearchCondition;
import com.tsingsoft.android.util.AccuracyRateUtil;
import com.tsingsoft.android.util.DateUtil;
import com.tsingsoft.android.util.NumberUtil;
import com.tsingsoft.android.util.PointLoadHandleUtil;
import com.tsingsoft.android.util.PointTime;
import com.tsingsoft.android.util.StringUtil;

/**
 * <pre>
 * 负荷监控 - demo使用Sqlite - 处理数据逻辑
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月26日
 */
public class LoadMonitorSqliteDemoHelper extends BaseSliteDemoHelper {

	/** 负荷偏差的值 */
	private String loadOffset;

	/** 当前系统时间 */
	private Date curDate;
	/** 时刻点对象(计算延迟之后的) */
	private PointTime pointTime;
	/** 日期和相应的时刻点数据，key：日期(格式yyyyMMdd)，value：时刻点的集合（例如：T0015,T0030） */
	private Map<String, List<String>> ymdPointMap;
	/** 获取负荷的日期集合（格式yyyyMMdd） */
	private List<String> loadYmdList;
	/** 监控时刻点的历史负荷 */
	private Double pointHisLoad;
	/** 监控时刻点的预测负荷 */
	private Double pointForecastLoad;
	private String[] netIds = null;
	private String[] loadOffsets = null;

	public LoadMonitorSqliteDemoHelper(ServerSearchCondition condition, Context context) {
		this.context = context;
		initParam(condition);
	}

	public String getResult() {
		List<TreeMap<String, Object>> list = new ArrayList<TreeMap<String, Object>>();
		TreeMap<String, Object> result = null;
		try {
			for (int i = 0; i < netIds.length; i++) {
				netId = netIds[i];
				result = new TreeMap<String, Object>();

				loadOffset = loadOffsets[i];
				if (loadOffset == null || loadOffset.equals("null")) {
					continue;
				}

				List<Object> hisLoadList = getHisLoad();
				// 历史负荷
				result.put("hisLoad", hisLoadList);
				// 预测负荷
				List<Object> forecastLoadList = getForecastLoad();
				result.put("forecastLoad", forecastLoadList);

				// 时刻点
				result.put("pointTimeList", getPointTime96());
				// result.put("pointTimeList", getPointTimeList());
				// 时刻点准确率
				result.put("pointAccuracyRate", accuracyRate());
				// 日准确率
				result.put("dayAccuracyRate", accuracyDayRate(hisLoadList, forecastLoadList));
				// 负荷偏差
				result.put("loadAccuracyOffset", accuracyOffset());

				result.put("rtnNetId", netId);
				// 系统当前时间
				result.put("curYmd", DateUtil.formatDate(curDate, "yyyy.MM.dd"));
				result.put("curHourMinute", DateUtil.formatDate(curDate, "HH:mm"));
				// 负荷时刻点数据
				String point = pointTime.getPoint();
				result.put("point", PointLoadHandleUtil.convertPointTimeKey(point));
				result.put("pointHisLoad", numberFormatValue(pointHisLoad));
				result.put("pointForecastLoad", numberFormatValue(pointForecastLoad));

				// 时刻点的 实际负荷和预测负荷之间的偏差 超过了设置的偏差值 的结果（绝对值）
				result.put("pointLoadOverOffset", getPointLoadOverOffset(loadOffsets[i]));
				// 监控图形的图例 显示的日期
				result.put("legendYmd", getLegendYmd());
				list.add(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put(SysConstant.ERROR_MESSAGE, "获取数据失败");
		}
		String jsonStr = JSONArray.toJSONString(list);
		return jsonStr;
	}

	/**
	 * 初始化参数
	 * 
	 * @throws UnsupportedEncodingException
	 */
	private void initParam(ServerSearchCondition condition) {
		curDate = SqliteDemoDataConstants.getDefaultCurDate();
		int delayTime = 0;
		delayTime = Integer.valueOf(getParameterValue("delayTime", condition));
		Date delyDate = DateUtil.addMinute(curDate, -delayTime);
		pointTime = DateUtil.getPrePonitTime96Point(delyDate);
		netId = getParameterValue("netId", condition);
		caliberId = getParameterValue("caliberId", condition);
		loadOffset = getParameterValue("loadOffset", condition);
		loadOffsets = loadOffset.split(",");
		netIds = netId.split(",");
		// 传递过来的是单位为小时
		String timeOffset = getParameterValue("timeOffset", condition);

		int offsetPointNum = Integer.valueOf(timeOffset) * 4;
		ymdPointMap = DateUtil.getPointTimeOffset96Point(pointTime.getYmd(), pointTime.getPoint(),
				offsetPointNum);
		loadYmdList = new ArrayList<String>();
		for (String ymd : ymdPointMap.keySet()) {
			loadYmdList.add(ymd);
		}
	}

	/**
	 * 负荷时刻点，转成00:15格式的结果
	 */
	private List<Object> getPointTimeList() {
		List<Object> result = new ArrayList<Object>();
		if (loadYmdList.isEmpty()) {
			return result;
		}
		for (Entry<String, List<String>> entry : ymdPointMap.entrySet()) {
			for (String point : entry.getValue()) {
				result.add(PointLoadHandleUtil.convertPointTimeKey(point));
			}
		}
		return result;
	}

	private List<Object> getPointTime96() {
		String[] columns = SysConstant.DAY_LOAD_CURVE_96COLUMN;
		List<Object> result = new ArrayList<Object>();
		for (int i = 0; i < columns.length; i++) {
			String point = columns[i];
			result.add(PointLoadHandleUtil.convertPointTimeKey(point));
		}
		return result;
	}

	/**
	 * 监控图形的图例 显示的日期
	 */
	private String getLegendYmd() {
		String result = "-";
		for (String ymd : loadYmdList) {
			Date date = DateUtil.parseDate(ymd);
			result += DateUtil.formatDate(date, "yyyy年MM月dd日");
		}
		return result.substring(1);
	}

	/**
	 * 获取历史负荷
	 * 
	 * @return
	 */
	private List<Object> getHisLoad() {
		List<Object> result = new ArrayList<Object>();
		if (loadYmdList.isEmpty()) {
			return result;
		}
		LfHis96LcDao service = new LfHis96LcDao(context);
		TreeMap<String, LfHis96Lc> hisLoad = service.getDatas(netId, caliberId, loadYmdList);
		for (Entry<String, List<String>> entry : ymdPointMap.entrySet()) {
			String ymd = entry.getKey();
			LfHis96Lc lfHis96Lc = hisLoad.get(ymd);
			TreeMap<String, Double> dataMap = new TreeMap<String, Double>();
			if (lfHis96Lc != null) {
				dataMap = lfHis96Lc.getData();
			}
			for (Entry<String, Double> e : dataMap.entrySet()) {
				Object value = numberFormatValue(e.getValue());
				result.add(value);
			}
			// 获取监控时刻点的历史负荷
			if (ymd.equals(pointTime.getYmd())) {
				pointHisLoad = dataMap.get(pointTime.getPoint());
			}
		}
		return result;
	}

	/**
	 * 获取预测数据
	 */
	private List<Object> getForecastLoad() {
		List<Object> result = new ArrayList<Object>();
		if (loadYmdList.isEmpty()) {
			return result;
		}
		StFc96LcSubmitDao dao = new StFc96LcSubmitDao(context);
		List<StFc96LcSubmit> submitList = dao.find(netId, caliberId, loadYmdList);
		for (Entry<String, List<String>> entry : ymdPointMap.entrySet()) {
			String ymd = entry.getKey();
			TreeMap<String, Double> dataMap = new TreeMap<String, Double>();
			for (StFc96LcSubmit submit : submitList) {
				if (ymd.equals(submit.getYmd())) {
					dataMap = submit.getPoints();
					break;
				}
			}

			for (Entry<String, Double> e : dataMap.entrySet()) {
				Object value = numberFormatValue(e.getValue());
				result.add(value);
			}

			// 获取监控时刻点的预测负荷
			if (ymd.equals(pointTime.getYmd())) {
				pointForecastLoad = dataMap.get(pointTime.getPoint());
			}
		}
		return result;
	}

	/**
	 * 计算准确率
	 * 
	 * @param hisLoadMap
	 * @param forecastLoadMap
	 * @return
	 */
	private String accuracyRate() {
		// 计算的是时刻点的偏差率
		Double rate = AccuracyRateUtil.deviationRate(pointHisLoad, pointForecastLoad);
		if (rate != null) {
			rate = (1 - rate) * 100;
		}
		String result = numberFormatValue(rate);
		if (!StringUtil.isEmpty(result)) {
			result += "%";
		}
		return result;
	}

	/**
	 * 计算偏差量
	 * 
	 * @return
	 */
	private String accuracyOffset() {
		Double result = NumberUtil.reduce(pointForecastLoad, pointHisLoad);
		return numberFormatValue(result);
	}

	/**
	 * 计算日准确率
	 * 
	 * @return
	 */
	private String accuracyDayRate(List<Object> his, List<Object> forecast) {
		List<Double> hisList = new ArrayList<Double>();
		List<Double> forecastList = new ArrayList<Double>();
		for (Object obj : his) {
			if (obj != null && !obj.equals("")) {
				hisList.add(Double.parseDouble(obj.toString()));
			} else {
				hisList.add(null);
			}
		}

		for (Object obj : forecast) {
			if (obj != null && !obj.equals("")) {
				forecastList.add(Double.parseDouble(obj.toString()));
			} else {
				forecastList.add(null);
			}
		}
		Double rate = AccuracyRateUtil.accuracyRate(hisList, forecastList);
		if(rate != null) {
			rate = rate * 100;
		}
		String result = numberFormatValue(rate);
		if(!StringUtil.isEmpty(result)) {
			result += "%";
		}
		return result;

	}

	/**
	 * 时刻点的 实际负荷和预测负荷之间的偏差 超过了设置的偏差值 的结果（绝对值）
	 */
	private String getPointLoadOverOffset(String loadOffset) {
		String result = "";
		if (StringUtil.isEmpty(loadOffset)) {
			return result;
		}
		Double offset = NumberUtil.reduce(pointHisLoad, pointForecastLoad);
		if (offset == null) {
			return result;
		}
		offset = Math.abs(offset);
		try {
			Double loadOverOffset = NumberUtil.reduce(offset, Double.valueOf(loadOffset));
			if (loadOverOffset != null && loadOverOffset > 0) {
				result = numberFormatValue(loadOverOffset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!StringUtil.isEmpty(result)) {
			String currentHT = DateUtil.formatDate(curDate, "HH:mm");
			String time = changeCurrentTime(currentHT);
			result = time + "超过偏差警报，超过值为" + result;
		}
		return result;
	}

	private String changeCurrentTime(String currentTime) {
		String time = null;
		if (currentTime != null && currentTime.length() > 0) {
			String[] arr = currentTime.split(":");
			if (arr.length > 0) {
				String hour = arr[0];
				int min = Integer.parseInt(arr[1]);
				if (0 <= min && min < 15) {
					time = hour + "点" + 00 + "分";
				} else if (15 <= min && min < 30) {
					time = hour + "点" + 15 + "分";
				} else if (30 <= min && min < 45) {
					time = hour + "点" + 30 + "分";
				} else {
					time = hour + "点" + 45 + "分";
				}
			}
		}
		return time;
	}

}
