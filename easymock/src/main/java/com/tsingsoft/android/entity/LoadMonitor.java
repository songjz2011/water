package com.tsingsoft.android.entity;

import java.util.List;

/**
 * <pre>
 * 监控实体
 * 说明：
 * 1、负荷数据的日期（loadYmd）：因为获取负荷数据的时间，可能和当前时间不是同一天（因为设置了延迟时间）
 * 例如：延迟时间为15分钟，当前时间为20131010 00:03，则获取时刻点的数据为20131009 23:45
 * 则：curHourMinute=00:03，curYmd=2013-10-10；loadYmd=20131009，point=23:45
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月10日
 */
public class LoadMonitor {

	/** 当前时分（格式：02:43，2点43分） */
	private String curHourMinute;

	/** 当前日期（格式：2013.10.18） */
	private String curYmd;

	/** 时刻点(根据当前的时分，计算得到相应96点的时刻点，例如当前时分02:43，则该值为02:30) */
	private String point;

	/** 时刻点历史负荷 */
	private String pointHisLoad;

	/** 时刻点预测负荷 */
	private String pointForecastLoad;

	/** 时刻点准确率 */
	private String pointAccuracyRate;
	
	/**
	 * 日准确率
	 */
	private String dayAccuracyRate;
	
	/**
	 * 负荷偏差  预测负荷-实际负荷
	 */
	private String LoadOffset;

	/**
	 * 时刻点的 实际负荷和预测负荷之间的偏差 超过了设置的偏差值 的结果（绝对值），若不为空，则表示超过了 可用StringUtil.isEmpty判断
	 */
	private String pointLoadOverOffset;

	/** 负荷时刻点 */
	private List<String> pointTimeList;

	/** 历史负荷 */
	private List<Double> hisLoadList;

	/** 预测负荷 */
	private List<Double> forecastLoadList;
	
	private String netId;
	
	List<LoadMonitor> loadMonitors;

	/** 监控图形的图例 显示的日期 */
	private String legendYmd;

	public String getCurHourMinute() {
		return curHourMinute;
	}

	public void setCurHourMinute(String curHourMinute) {
		this.curHourMinute = curHourMinute;
	}

	public String getCurYmd() {
		return curYmd;
	}

	public void setCurYmd(String curYmd) {
		this.curYmd = curYmd;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getPointHisLoad() {
		return pointHisLoad;
	}

	public void setPointHisLoad(String pointHisLoad) {
		this.pointHisLoad = pointHisLoad;
	}

	public String getPointForecastLoad() {
		return pointForecastLoad;
	}

	public void setPointForecastLoad(String pointForecastLoad) {
		this.pointForecastLoad = pointForecastLoad;
	}

	public String getPointAccuracyRate() {
		return pointAccuracyRate;
	}

	public void setPointAccuracyRate(String pointAccuracyRate) {
		this.pointAccuracyRate = pointAccuracyRate;
	}

	public String getPointLoadOverOffset() {
		return pointLoadOverOffset;
	}

	public void setPointLoadOverOffset(String pointLoadOverOffset) {
		this.pointLoadOverOffset = pointLoadOverOffset;
	}

	public List<String> getPointTimeList() {
		return pointTimeList;
	}

	public void setPointTimeList(List<String> pointTimeList) {
		this.pointTimeList = pointTimeList;
	}

	public List<Double> getHisLoadList() {
		return hisLoadList;
	}

	public void setHisLoadList(List<Double> hisLoadList) {
		this.hisLoadList = hisLoadList;
	}

	public List<Double> getForecastLoadList() {
		return forecastLoadList;
	}

	public void setForecastLoadList(List<Double> forecastLoadList) {
		this.forecastLoadList = forecastLoadList;
	}

	public String getLegendYmd() {
		return legendYmd;
	}

	public void setLegendYmd(String legendYmd) {
		this.legendYmd = legendYmd;
	}

	public List<LoadMonitor> getLoadMonitors() {
		return loadMonitors;
	}

	public void setLoadMonitors(List<LoadMonitor> loadMonitors) {
		this.loadMonitors = loadMonitors;
	}

	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public String getLoadOffset() {
		return LoadOffset;
	}

	public void setLoadOffset(String loadOffset) {
		LoadOffset = loadOffset;
	}

	public String getDayAccuracyRate() {
		return dayAccuracyRate;
	}

	public void setDayAccuracyRate(String dayAccuracyRate) {
		this.dayAccuracyRate = dayAccuracyRate;
	}
}
