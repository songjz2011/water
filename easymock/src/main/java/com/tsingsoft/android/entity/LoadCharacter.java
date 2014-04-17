package com.tsingsoft.android.entity;

/**
 * 负荷特性bean
 * 
 * @author F.Liu
 * 
 */
public class LoadCharacter {

	/** 负荷特性日期(格式：yyyy年MM月dd日) */
	private String ymd;

	/**
	 * 最大(高)负荷
	 */
	private String maxLoad;
	/**
	 * 最大(高)负荷时刻
	 */
	private String maxLoadTime;
	/**
	 * 最小(低)负荷
	 */
	private String minLoad;
	/**
	 * 最小(低)负荷时刻
	 */
	private String minLoadTime;
	/**
	 * 平均负荷
	 */
	private String avgLoad;
	/**
	 * 峰谷差
	 */
	private String difference;

	/**
	 * 峰谷差率
	 */
	private String differenceRate;

	/**
	 * 负荷率
	 */
	private String loadRate;

	public String getYmd() {
		return ymd;
	}

	public void setYmd(String ymd) {
		this.ymd = ymd;
	}

	public String getMaxLoad() {
		return maxLoad;
	}

	public void setMaxLoad(String maxLoad) {
		this.maxLoad = maxLoad;
	}

	public String getMaxLoadTime() {
		return maxLoadTime;
	}

	public void setMaxLoadTime(String maxLoadTime) {
		this.maxLoadTime = maxLoadTime;
	}

	public String getMinLoad() {
		return minLoad;
	}

	public void setMinLoad(String minLoad) {
		this.minLoad = minLoad;
	}

	public String getMinLoadTime() {
		return minLoadTime;
	}

	public void setMinLoadTime(String minLoadTime) {
		this.minLoadTime = minLoadTime;
	}

	public String getAvgLoad() {
		return avgLoad;
	}

	public void setAvgLoad(String avgLoad) {
		this.avgLoad = avgLoad;
	}

	public String getDifference() {
		return difference;
	}

	public void setDifference(String difference) {
		this.difference = difference;
	}

	public String getDifferenceRate() {
		return differenceRate;
	}

	public void setDifferenceRate(String differenceRate) {
		this.differenceRate = differenceRate;
	}

	public String getLoadRate() {
		return loadRate;
	}

	public void setLoadRate(String loadRate) {
		this.loadRate = loadRate;
	}

}
