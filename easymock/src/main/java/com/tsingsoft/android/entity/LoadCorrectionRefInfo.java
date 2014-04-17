package com.tsingsoft.android.entity;

/**
 * 负荷修正参考信息表实体
 * @author F.Liu
 *
 */
public class LoadCorrectionRefInfo {
	/**
	 * 参考日期
	 */
	private String refDate;
	
	/**
	 * 电网
	 */
	private String netId;
	
	/**
	 * 口径
	 */
	private String caliberId;
	
	/**
	 * 预测日期
	 */
	private String forecastDate;

	public String getRefDate() {
		return refDate;
	}

	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

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

	public String getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(String forecastDate) {
		this.forecastDate = forecastDate;
	}
}
