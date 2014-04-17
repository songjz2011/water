package com.tsingsoft.android.entity;

import java.util.TreeMap;

/**
 * <pre>
 * 96点上报预测负荷
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月26日
 */
public class StFc96LcSubmit {
	/** 电网号 */
	private String netId;
	/** 口径 */
	private String caliberId;
	/** 年月日 */
	private String ymd;

	/** 96点数据（key：T0015，value：负荷值） */
	private TreeMap<String, Double> points;

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

	public TreeMap<String, Double> getPoints() {
		return points;
	}

	public void setPoints(TreeMap<String, Double> points) {
		this.points = points;
	}
}
