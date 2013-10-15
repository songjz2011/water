package com.web.things.jfreechart;

import java.util.List;

/**
 * <pre>
 * 绘制图形时，用到的参数
 * </pre>
 * 
 * @author songjz
 * @time 2013年8月1日
 */
public class BasicChartPara {
	/** 生成图片的id，默认可以由系统自动设置（通过） */
	private String chartId;
	/** 图片位置 */
	private String imageAlign = "center";
	/** 图片的长度 */
	private int width = 800;
	/** 图片的高度 */
	private int height = 400;
	/** 图片标题 */
	private String title = "";
	/** 图片子标题 */
	private String subTitle = "";
	/** 图片的背景颜色，目前仅支持"#FFFFFF"格式 */
	private String backGroundColor = "";
	/** 图形区的背景颜色， 目前仅支持"#FFFFFF"格式 */
	private String plotBackGroundColor = "";

	/**
	 * 是否显示图例，默认显示
	 */
	private boolean showLegend = true;

	/**
	 * 横坐标名称
	 */
	private String domainLabel = "";
	/**
	 * 纵坐标名称
	 */
	private String rangeLabel = "";
	/**
	 * 每个数据点在x轴显示的名称（例如：在X轴显示00:15）<br>
	 * 这个值得长度好最要和一条线上数据的个数保持一致，若不一致，则为自然数<br>
	 * 暂使用到：曲线、柱状图形
	 */
	private String[] domainAxisSymbols;

	/**
	 * <pre>
	 * DTLN domain tick lable number : 意思使:domain Axis游标的数量
	 * 1、该变量的作用为:在点数不确定的时候or当点数的数量大于该变量的数量的时候,使游标(横坐标的名称)的标记垂直
	 * 2、该变量和domainAxisSymbols进行绑定（原因：若不设置dataXName时，是使用自然数进行展示值得横坐标名称），
	 * 		若domainAxisSymbols的长度大于该值时，则垂直展示
	 * </pre>
	 */
	private int verticalDTLN = 48;
	
	/**
	 * 图表数据
	 */
	private List<ChartData> chartDataList;

	/**
	 * @return the chartId
	 */
	public String getChartId() {
		return chartId;
	}

	/**
	 * @param chartId the chartId to set
	 */
	public void setChartId(String chartId) {
		this.chartId = chartId;
	}

	/**
	 * @return the imageAlign
	 */
	public String getImageAlign() {
		return imageAlign;
	}

	/**
	 * @param imageAlign the imageAlign to set
	 */
	public void setImageAlign(String imageAlign) {
		this.imageAlign = imageAlign;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the subTitle
	 */
	public String getSubTitle() {
		return subTitle;
	}

	/**
	 * @param subTitle the subTitle to set
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	/**
	 * @return the backGroundColor
	 */
	public String getBackGroundColor() {
		return backGroundColor;
	}

	/**
	 * @param backGroundColor the backGroundColor to set
	 */
	public void setBackGroundColor(String backGroundColor) {
		this.backGroundColor = backGroundColor;
	}

	/**
	 * @return the plotBackGroundColor
	 */
	public String getPlotBackGroundColor() {
		return plotBackGroundColor;
	}

	/**
	 * @param plotBackGroundColor the plotBackGroundColor to set
	 */
	public void setPlotBackGroundColor(String plotBackGroundColor) {
		this.plotBackGroundColor = plotBackGroundColor;
	}

	/**
	 * @return the showLegend
	 */
	public boolean isShowLegend() {
		return showLegend;
	}

	/**
	 * @param showLegend the showLegend to set
	 */
	public void setShowLegend(boolean showLegend) {
		this.showLegend = showLegend;
	}

	/**
	 * @return the domainLabel
	 */
	public String getDomainLabel() {
		return domainLabel;
	}

	/**
	 * @param domainLabel the domainLabel to set
	 */
	public void setDomainLabel(String domainLabel) {
		this.domainLabel = domainLabel;
	}

	/**
	 * @return the rangeLabel
	 */
	public String getRangeLabel() {
		return rangeLabel;
	}

	/**
	 * @param rangeLabel the rangeLabel to set
	 */
	public void setRangeLabel(String rangeLabel) {
		this.rangeLabel = rangeLabel;
	}

	/**
	 * @return the domainAxisSymbols
	 */
	public String[] getDomainAxisSymbols() {
		return domainAxisSymbols;
	}

	/**
	 * @param domainAxisSymbols the domainAxisSymbols to set
	 */
	public void setDomainAxisSymbols(String[] domainAxisSymbols) {
		this.domainAxisSymbols = domainAxisSymbols;
	}

	/**
	 * @return the verticalDTLN
	 */
	public int getVerticalDTLN() {
		return verticalDTLN;
	}

	/**
	 * @param verticalDTLN the verticalDTLN to set
	 */
	public void setVerticalDTLN(int verticalDTLN) {
		this.verticalDTLN = verticalDTLN;
	}

	/**
	 * @return the chartDataList
	 */
	public List<ChartData> getChartDataList() {
		return chartDataList;
	}

	/**
	 * @param chartDataList the chartDataList to set
	 */
	public void setChartDataList(List<ChartData> chartDataList) {
		this.chartDataList = chartDataList;
	}

}
