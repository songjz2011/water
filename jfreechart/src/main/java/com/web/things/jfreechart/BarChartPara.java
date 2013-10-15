package com.web.things.jfreechart;

/**
 * <pre>
 * 绘制柱状图形时，用到的参数
 * </pre>
 * 
 * @author songjz
 * @time 2013年8月3日
 */
public class BarChartPara extends BasicChartPara {
	/** 横坐标名称 */
	private String domainAxisLabel = "";
	/** 纵坐标名称 */
	private String rangeAxisLabel = "";
	/** 每个数据点在x轴显示的名称（例如：在X轴显示00:15），这个值得长度好最要和一条线上数据的个数保持一致，默认为自然数 */
	private String[] domainAxisSymbols;

	/**
	 * @return the domainAxisLabel
	 */
	public String getDomainAxisLabel() {
		return domainAxisLabel;
	}

	/**
	 * @param domainAxisLabel
	 *            the domainAxisLabel to set
	 */
	public void setDomainAxisLabel(String domainAxisLabel) {
		this.domainAxisLabel = domainAxisLabel;
	}

	/**
	 * @return the rangeAxisLabel
	 */
	public String getRangeAxisLabel() {
		return rangeAxisLabel;
	}

	/**
	 * @param rangeAxisLabel
	 *            the rangeAxisLabel to set
	 */
	public void setRangeAxisLabel(String rangeAxisLabel) {
		this.rangeAxisLabel = rangeAxisLabel;
	}

	/**
	 * @return the domainAxisSymbols
	 */
	public String[] getDomainAxisSymbols() {
		return domainAxisSymbols;
	}

	/**
	 * @param domainAxisSymbols
	 *            the domainAxisSymbols to set
	 */
	public void setDomainAxisSymbols(String[] domainAxisSymbols) {
		this.domainAxisSymbols = domainAxisSymbols;
	}
}
