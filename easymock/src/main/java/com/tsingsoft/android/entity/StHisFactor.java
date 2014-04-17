package com.tsingsoft.android.entity;

/**
 * <pre>
 * 历史相关信息数据
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月26日
 */
public class StHisFactor {

	/** 相关因素ID */
	private String factorId;

	/** 电网ID */
	private String netId;

	/** 日期 */
	private String ymd;

	/** 相关因素值 */
	private Double beforeValue;

	public String getFactorId() {
		return factorId;
	}

	public void setFactorId(String factorId) {
		this.factorId = factorId;
	}

	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public String getYmd() {
		return ymd;
	}

	public void setYmd(String ymd) {
		this.ymd = ymd;
	}

	public Double getBeforeValue() {
		return beforeValue;
	}

	public void setBeforeValue(Double beforeValue) {
		this.beforeValue = beforeValue;
	}
}
