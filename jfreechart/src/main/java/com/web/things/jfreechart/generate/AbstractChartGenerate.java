package com.web.things.jfreechart.generate;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.web.things.jfreechart.BasicChartPara;
import com.web.things.jfreechart.ChartData;
import com.web.things.jfreechart.exception.ChartParaTypeMismatchingException;
import com.web.things.util.StringUtil;

/**
 * <pre>
 * 做为图形生成的抽象类，增加了获取图形Dataset的抽象方法
 * </pre>
 * 
 * @author songjz
 * @time 2013年8月1日
 */
public abstract class AbstractChartGenerate implements IChartGenerate {

	protected abstract void validateChartParaType(BasicChartPara chartPara)
			throws ChartParaTypeMismatchingException;

	/**
	 * 获取默认的ChartRenderingInfo
	 */
	public ChartRenderingInfo getChartRenderingInfo() {
		StandardEntityCollection sec = new StandardEntityCollection();
		ChartRenderingInfo info = new ChartRenderingInfo(sec);
		return info;
	}

	public String getChartGraphUrl(JFreeChart chart, int width, int height,
			ChartRenderingInfo info, HttpServletRequest request) {
		try {
			String filename = ServletUtilities.saveChartAsPNG(chart, width, height, info,
					request.getSession());
			String url = request.getContextPath() + "/servlet/DisplayChart?filename=" + filename;
			return url;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 设置JFreeChart的基本样式
	 * 
	 * @param chart
	 * @param chartPara
	 */
	protected void setChartBasicStyle(JFreeChart chart, BasicChartPara chartPara) {
		setChartTitleStyle(chart, chartPara);
		setBackColorStyle(chart, chartPara);
		setNoDataMessageStyle(chart);
		setLegendStyle(chart, chartPara);
		setLabelFont(chart);
		// 设置图片是否抗锯齿
		chart.setAntiAlias(false);
	}

	/**
	 * 设置坐标轴标题的字体
	 * 
	 * @param chart
	 */
	private void setLabelFont(JFreeChart chart) {
		if (chart.getPlot() == null) {
			return;
		}
		if (chart.getPlot() instanceof CategoryPlot) {
			CategoryPlot plot = (CategoryPlot) chart.getPlot();
			plot.getRangeAxis().setLabelFont(ChartGenerateConstant.DEFAULT_VALUE_LABEL_FONT);
			plot.getDomainAxis().setLabelFont(ChartGenerateConstant.DEFAULT_VALUE_LABEL_FONT);
		} else if (chart.getPlot() instanceof XYPlot) {
			XYPlot plot = (XYPlot) chart.getPlot();
			plot.getRangeAxis().setLabelFont(ChartGenerateConstant.DEFAULT_VALUE_LABEL_FONT);
			plot.getDomainAxis().setLabelFont(ChartGenerateConstant.DEFAULT_VALUE_LABEL_FONT);
		}
	}

	/**
	 * 设置图例的样式
	 * 
	 * @param chart
	 * @param lineChartPara
	 */
	private void setLegendStyle(JFreeChart chart, BasicChartPara chartPara) {
		if (!chartPara.isShowLegend() || chart.getLegend() == null) {
			chart.removeLegend();
			return;
		}
		LegendTitle legend = chart.getLegend();
		if (legend != null) {
			legend.setItemFont(ChartGenerateConstant.DEFAULT_VALUE_LABEL_FONT);
		}
	}

	/**
	 * 设置title样式
	 * 
	 * @param chart
	 * @param chartPara
	 */
	private void setChartTitleStyle(JFreeChart chart, BasicChartPara chartPara) {
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(ChartGenerateConstant.TITLE_FONT);
		if (!StringUtil.isEmpty(chartPara.getSubTitle())) {
			chart.addSubtitle(new TextTitle(chartPara.getSubTitle(),
					ChartGenerateConstant.SUB_TITLE_FONT));
		}
	}

	/**
	 * 设置背景颜色样式
	 * 
	 * @param chart
	 * @param chartPara
	 */
	private void setBackColorStyle(JFreeChart chart, BasicChartPara chartPara) {
		// 设置整体图片背景色
		chart.setBackgroundPaint(ChartGenerateConstant.DEFAULT_BACKGROUND_PAINT);
		String backGroundColor = chartPara.getBackGroundColor();
		if (!StringUtil.isEmpty(backGroundColor)) {
			chart.setBackgroundPaint(new Color(Integer.parseInt(backGroundColor.substring(1), 16)));
		}
		// 设置图形区的背景色
		chart.getPlot().setBackgroundPaint(ChartGenerateConstant.DEFAULT_PLOT_PAINT);
		String plotBackGroundColor = chartPara.getPlotBackGroundColor();
		if (!StringUtil.isEmpty(plotBackGroundColor)) {
			chart.getPlot().setBackgroundPaint(
					new Color(Integer.parseInt(plotBackGroundColor.substring(1), 16)));
		}
	}

	/**
	 * 设置没有数据情况下，图形展示样式
	 * 
	 * @param chart
	 */
	private void setNoDataMessageStyle(JFreeChart chart) {
		chart.getPlot().setNoDataMessage("在该查询条件下无数据,请重新查询!");
		chart.getPlot().setNoDataMessagePaint(ChartGenerateConstant.N0_DATA_MESSAGE_PAINT);
	}

	/**
	 * 构造line的数据
	 * 
	 * @param chartPara
	 * @return
	 */
	protected CategoryDataset buildDataSet(BasicChartPara chartPara) {
		List<ChartData> list = chartPara.getChartDataList();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if (list == null || list.isEmpty()) {
			return dataset;
		}
		String[] domainAxisSymbols = chartPara.getDomainAxisSymbols();
		for (int i = 0; i < list.size(); i++) {
			if (i > 30) {
				break;
			}
			ChartData chartData = list.get(i);
			List<String> dataList = chartData.getDataList();
			if (dataIsEmpty(dataList)) {
				continue;
			}
			for (int j = 0; j < dataList.size(); j++) {
				String axisSymbol = getDomainAxisSymbol(domainAxisSymbols, j);
				Number data = null;
				if (!StringUtil.isEmpty(dataList.get(j))) {
					data = Double.parseDouble(dataList.get(j).trim());
				}
				String lengendName = StringUtil.killNull(chartData.getLegendName());
				if (StringUtil.isEmpty(lengendName)) {
					lengendName = String.valueOf(i);
				}
				dataset.addValue(data, lengendName, axisSymbol);
			}
		}
		return dataset;
	}

	/**
	 * 数据点在x轴显示的名称
	 * 
	 * @param domainAxisSymbols
	 * @param index
	 * @return
	 */
	private String getDomainAxisSymbol(String[] domainAxisSymbols, int index) {
		String symbol = String.valueOf(index);
		if (domainAxisSymbols != null && index < domainAxisSymbols.length) {
			symbol = domainAxisSymbols[index];
		}
		return symbol;
	}

	/**
	 * 数据是否为空
	 * 
	 * @param dataList
	 * @return
	 */
	protected boolean dataIsEmpty(List<String> dataList) {
		if (dataList == null || dataList.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 获取每个domain设置的颜色
	 * 
	 * @param chartDataList
	 * @return
	 */
	protected List<String> getDomainColors(List<ChartData> chartDataList) {
		List<String> colorList = new ArrayList<String>();
		if (chartDataList == null || chartDataList.isEmpty()) {
			return colorList;
		}
		for (ChartData chartData : chartDataList) {
			if (dataIsEmpty(chartData.getDataList())) {
				continue;
			}
			colorList.add(StringUtil.killNull(chartData.getColor()));
		}
		return colorList;
	}

}
