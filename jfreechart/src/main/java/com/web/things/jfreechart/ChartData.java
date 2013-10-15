package com.web.things.jfreechart;

import java.util.List;

/**
 * <pre>
 * 图形数据
 * </pre>
 * 
 * @author songjz
 * @time 2013年8月5日
 */
public class ChartData {

	/**
	 * <pre>
	 * 图例的名称，说明如下：
	 * 1、曲线：对每条线的说明
	 * 2、柱子：对相同颜色的柱子的说明
	 * 3、饼状图：对每个区域的说明
	 * </pre>
	 */
	private String legendName;

	/**
	 * domain(线、柱、区域)的颜色，目前只支持"#FF0000"格式
	 */
	private String color;

	/**
	 * 图表数据
	 */
	private List<String> dataList;

	/**
	 * @return the legendName
	 */
	public String getLegendName() {
		return legendName;
	}

	/**
	 * @param legendName
	 *            the legendName to set
	 */
	public void setLegendName(String legendName) {
		this.legendName = legendName;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the dataList
	 */
	public List<String> getDataList() {
		return dataList;
	}

	/**
	 * @param dataList
	 *            the dataList to set
	 */
	public void setDataList(List<String> dataList) {
		this.dataList = dataList;
	}

}
