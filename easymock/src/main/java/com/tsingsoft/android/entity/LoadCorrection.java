package com.tsingsoft.android.entity;

import java.util.List;

/**
 * 负荷修正bean
 * 
 * @author F.Liu
 * 
 */
public class LoadCorrection {
	
	/**
	 * 负荷修正表主键ID
	 */
	private int correctionId;
	
	/**
	 * 系统当前时间
	 */
	private String sysCurDate;
	
	/**
	 * 负荷修正的入口
	 * 0：默认，从负荷修正菜单进入
	 * 1：上报，从上报入口进入
	 */
	private String type="0";
	
	/**
	 * 预测曲线的预测号
	 */
	private String fcNO;
	
	
	/**
	 * 预测日期
	 */
	private String forecastDate;
	
	/**
	 * 参考日期
	 */
	private String referenceDate;
	
	/**
	 * 默认参考日期列表(昨天，前天)
	 */
	private List<String> defaultRefDate;

	/**
	 * 负荷特性
	 */
	private LoadCharacter loadCharacter;
	
	/**
	 * 修正口径
	 */
	private String caliberId;

	/**
	 * 电网信息
	 */
	private LfCtrlNet net;

	/**
	 * 参照曲线列表
	 */
	private List<List<Double>> hisLoadList;

	/**
	 * 预测曲线
	 */
	private List<Double> forecastLoadList;

	public String getSysCurDate() {
		return sysCurDate;
	}

	public void setSysCurDate(String sysCurDate) {
		this.sysCurDate = sysCurDate;
	}

	public LoadCharacter getLoadCharacter() {
		return loadCharacter;
	}

	public void setLoadCharacter(LoadCharacter loadCharacter) {
		this.loadCharacter = loadCharacter;
	}

	public LfCtrlNet getNet() {
		return net;
	}

	public void setNet(LfCtrlNet net) {
		this.net = net;
	}

	public List<List<Double>> getHisLoadList() {
		return hisLoadList;
	}

	public void setHisLoadList(List<List<Double>> hisLoadList) {
		this.hisLoadList = hisLoadList;
	}

	public List<Double> getForecastLoadList() {
		return forecastLoadList;
	}

	public void setForecastLoadList(List<Double> forecastLoadList) {
		this.forecastLoadList = forecastLoadList;
	}

	public String getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(String forecastDate) {
		this.forecastDate = forecastDate;
	}

	public String getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}

	public List<String> getDefaultRefDate() {
		return defaultRefDate;
	}

	public void setDefaultRefDate(List<String> defaultRefDate) {
		this.defaultRefDate = defaultRefDate;
	}

	public String getCaliberId() {
		return caliberId;
	}

	public void setCaliberId(String caliberId) {
		this.caliberId = caliberId;
	}

	public String getFcNO() {
		return fcNO;
	}

	public void setFcNO(String fcNO) {
		this.fcNO = fcNO;
	}

	public int getCorrectionId() {
		return correctionId;
	}

	public void setCorrectionId(int correctionId) {
		this.correctionId = correctionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
