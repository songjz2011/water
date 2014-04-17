package com.tsingsoft.android.entity;

import java.util.TreeMap;

/**
 * <pre>
 * 96点历史负荷
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月25日
 */
public class LfHis96Lc {

	/** 电网号 */
	private String netId;
	/** 口径 */
	private String caliberId;
	/** 年月日 */
	private String ymd;

	/** 96点数据（key：T0015，value：负荷值） */
	private TreeMap<String, Double> data;

	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public String getCaliberId() {
		return caliberId;
	}

	public void setCaliberId(String caliberId) {
		this.caliberId = caliberId;
	}

	public String getYmd() {
		return ymd;
	}

	public void setYmd(String ymd) {
		this.ymd = ymd;
	}

	public TreeMap<String, Double> getData() {
		return data;
	}

	public void setData(TreeMap<String, Double> data) {
		this.data = data;
	}

}
