package com.web.things.jfreechart.tag;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import com.web.things.jfreechart.BasicChartPara;
import com.web.things.jfreechart.generate.ChartGenerateFactory;
import com.web.things.jfreechart.generate.IChartGenerate;
import com.web.things.jfreechart.util.ChartGenerateUtil;
import com.web.things.util.StringUtil;

/**
 * <pre>
 * 图形标签(jFreeChart)
 * </pre>
 * 
 * @author songjz
 * @time 2013年7月30日
 */
public class ChartTag extends TagSupport {
	private static final long serialVersionUID = -1081910708431797661L;
	private BasicChartPara chartPara;
	/** 图片的长度 */
	private int width = 800;
	/** 图片的高度 */
	private int height = 400;

	@Override
	public int doStartTag() throws JspException {
		try {
			ChartGenerateUtil.validateChartParaNull(chartPara);
			setChartId(chartPara);
			chartPara.setWidth(width);
			chartPara.setHeight(height);
			IChartGenerate chartGenerate = ChartGenerateFactory.generate(chartPara);
			JFreeChart chart = chartGenerate.chartGender(chartPara);
			ChartRenderingInfo info = chartGenerate.getChartRenderingInfo();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			String chartGraphUrl = chartGenerate.getChartGraphUrl(chart, chartPara.getWidth(),
					chartPara.getHeight(), info, request);
			String userMapStr = getUseMapStr(info);
			pageContext.getOut().print(buildeChartGraphDiv(chartGraphUrl, userMapStr));
		} catch (Exception e) {
			e.printStackTrace();
			throw new JspException(e);
		}
		return SKIP_BODY;
	}

	/**
	 * 构造显示图片的DIV
	 * 
	 * @param chartGraphUrl
	 * @param useMapStr
	 * @return
	 */
	private String buildeChartGraphDiv(String chartGraphUrl, String useMapStr) {
		StringBuilder builder = new StringBuilder();
		builder.append("<div border=\"0\" align=\">").append(chartPara.getImageAlign())
				.append("\">");
		builder.append("<img src=\"").append(chartGraphUrl).append("\"");
		builder.append(" width=\"").append(chartPara.getWidth()).append("\"");
		builder.append(" height=\"").append(chartPara.getHeight()).append("\"");
		builder.append(useMapStr);
		builder.append(" >");
		builder.append("</div>");
		return builder.toString();
	}

	private String getUseMapStr(ChartRenderingInfo info) throws IOException {
		String mapName = "map_" + chartPara.getChartId();
		String useMapStr = "";
		if (true) {
			ChartUtilities.writeImageMap(new PrintWriter(pageContext.getOut()), mapName, info,
					false);
			useMapStr = "usemap='#" + mapName + "'";
		}
		return useMapStr;
	}

	/**
	 * 系统设置chartId
	 * 
	 * @param chartPara
	 * @param request
	 */
	private void setChartId(BasicChartPara chartPara) {
		if (!StringUtil.isEmpty(chartPara.getChartId())) {
			return;
		}
		chartPara.setChartId(pageContext.getSession().getId() + Math.random());
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	/**
	 * @return the chartPara
	 */
	public BasicChartPara getChartPara() {
		return chartPara;
	}

	/**
	 * @param chartPara
	 *            the chartPara to set
	 */
	public void setChartPara(BasicChartPara chartPara) {
		this.chartPara = chartPara;
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

}
