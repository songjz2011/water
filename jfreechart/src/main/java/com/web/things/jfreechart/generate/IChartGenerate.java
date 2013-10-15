package com.web.things.jfreechart.generate;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;

import com.web.things.jfreechart.BasicChartPara;

/**
 * <pre>
 * 图形生成的通用接口，不同类型的图表进行实现
 * </pre>
 * 
 * @author songjz
 * @time 2013年8月1日
 */
public interface IChartGenerate {
	/**
	 * 产生各种图形的实现
	 * 
	 * @return
	 * @throws Exception
	 */
	JFreeChart chartGender(BasicChartPara chartPara) throws Exception;

	/**
	 * 获取ChartRenderingInfo
	 * 
	 * @return
	 */
	ChartRenderingInfo getChartRenderingInfo();

	/**
	 * <pre>
	 * 这个是采用JFreeChart提供的org.jfree.chart.servlet.DisplayChart获取图片地址
	 * 使用方式，参见ChartTag.java
	 * </pre>
	 * 
	 * @param chart
	 * @param width
	 * @param height
	 * @param info
	 * @param session
	 * @return
	 */
	String getChartGraphUrl(JFreeChart chart, int width, int height, ChartRenderingInfo info,
			HttpServletRequest request);
}
