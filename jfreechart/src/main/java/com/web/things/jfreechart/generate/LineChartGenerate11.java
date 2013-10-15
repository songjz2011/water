package com.web.things.jfreechart.generate;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;

import com.web.things.jfreechart.BasicChartPara;
import com.web.things.jfreechart.LineChartPara;
import com.web.things.jfreechart.exception.ChartParaTypeMismatchingException;
import com.web.things.util.StringUtil;

/**
 * <pre>
 * 曲线图形生成类
 * 对chartPara.dataList数据的解析方式见buildDataSet方法：
 * </pre>
 * 
 * @author songjz
 * @time 2013年8月1日
 */
public class LineChartGenerate11 extends AbstractChartGenerate {
	private static LineChartGenerate11 line = new LineChartGenerate11();

	private LineChartGenerate11() {
	}

	public static LineChartGenerate11 getInstance() {
		return line;
	}

	/**
	 * 验证数据类型是否为LineChartPara
	 */
	@Override
	protected void validateChartParaType(BasicChartPara chartPara)
			throws ChartParaTypeMismatchingException {
		if (!(chartPara instanceof LineChartPara)) {
			throw new ChartParaTypeMismatchingException("chart para mismatching line...");
		}
	}

	public JFreeChart chartGender(BasicChartPara chartPara) throws Exception {
		validateChartParaType(chartPara);
		LineChartPara lineChartPara = (LineChartPara) chartPara;
		CategoryDataset dataset = buildDataSet(lineChartPara);
		JFreeChart chart = ChartFactory.createLineChart(chartPara.getTitle(),
				lineChartPara.getDomainLabel(), lineChartPara.getRangeLabel(),
				dataset, PlotOrientation.VERTICAL, true, true, false);
		// 设置JFreeChart的样式
		setChartStyle(chart, lineChartPara);
		return chart;
	}

	/**
	 * 设置JFreeChart的样式
	 * 
	 * @param chart
	 * @param lineChartPara
	 */
	private void setChartStyle(JFreeChart chart, LineChartPara lineChartPara) {
		setChartBasicStyle(chart, lineChartPara);
		setGridlineStyle(chart);
		setDomainAxisStyle(chart, lineChartPara);
		setRangeAxisStyle(chart);
		setLineStyle(chart, lineChartPara);
	}

	/**
	 * 设置每条线的样式
	 * 
	 * @param chart
	 * @param chartPara
	 */
	@SuppressWarnings("deprecation")
	private void setLineStyle(JFreeChart chart, LineChartPara chartPara) {
		LineAndShapeRenderer renderer = getChartRender(chart);
		// 设置是否显示曲线中各点的图形 默认为显示
		renderer.setBaseShapesVisible(chartPara.isShapesVisible());
		// 设置是否显示曲线中各点的图形为填充，若各点图形不显示，此设置不起作用
		renderer.setBaseShapesFilled(true);
		// 设置各点的tooltip
		if (chartPara.isShapesToolTipVisible()) {
			float diameter = chartPara.getShapeDiameter();
			renderer.setShape(new RoundRectangle2D.Float(-2.0f, -2.0f, diameter, diameter, 2.0f,
					2.0f));
			renderer.setBaseToolTipGenerator(buildCategoryToolTipGenerator(chart, chartPara));
		}
		// 设置各线的颜色
		setLineColor(chart, chartPara);
	}

	/**
	 * 每条线的颜色
	 * 
	 * @param chart
	 * @param chartPara
	 */
	private void setLineColor(JFreeChart chart, LineChartPara chartPara) {
		List<String> colorList = getDomainColors(chartPara.getChartDataList());
		if (colorList == null || colorList.isEmpty()) {
			return;
		}
		LineAndShapeRenderer renderer = getChartRender(chart);
		for (int i = 0; i < colorList.size(); i++) {
			String color = colorList.get(i);
			if (StringUtil.isEmpty(color)) {
				continue;
			}
			renderer.setSeriesPaint(i, new Color(Integer.parseInt(color.substring(1), 16)));
		}
	}

	/**
	 * 设置Y坐标轴的样式
	 * 
	 * @param chart
	 * @param lineChartPara
	 */
	private void setRangeAxisStyle(JFreeChart chart) {
		CategoryPlot plot = chart.getCategoryPlot();
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		numberAxis.setAutoRangeIncludesZero(false);
	}

	/**
	 * 设置X坐标轴的样式，包含：数据点在X轴显示名称（例如：00:15）、显示名称是否纵向展示
	 * 
	 * @param chart
	 * @param chartPara
	 */
	private void setDomainAxisStyle(JFreeChart chart, LineChartPara chartPara) {
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis axis = plot.getDomainAxis();
		String[] domainAxisSymbols = chartPara.getDomainAxisSymbols();
		if (domainAxisSymbols == null) {
			// 每个数据点在x轴的名称 不显示
			axis.setTickLabelsVisible(false);
			return;
		}
		axis.setTickLabelFont(ChartGenerateConstant.DEFAULT_VALUE_LABEL_FONT);
		// 图片边框的左右间距
		axis.setLowerMargin(0.005);
		axis.setUpperMargin(0.005);
		// 纵向展示
		Integer verticalDTLN = chartPara.getVerticalDTLN();
		if (verticalDTLN != null && verticalDTLN < domainAxisSymbols.length) {
			axis.setTickLabelFont(ChartGenerateConstant.SMALL_FONT);
			axis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		}
	}

	/**
	 * 设置网格线的样式
	 * 
	 * @param chart
	 */
	private void setGridlineStyle(JFreeChart chart) {
		CategoryPlot plot = chart.getCategoryPlot();
		// 设置纵轴网格线样式
		plot.setRangeGridlinesVisible(false);
		if (ChartGenerateConstant.DISPLAY_RANGE_GRIDLINE) {
			plot.setRangeGridlinesVisible(true);
			plot.setRangeGridlinePaint(ChartGenerateConstant.RANGE_GRIDLINE_PAINT);
		}
		// 设置横轴网格线样式
		plot.setDomainGridlinesVisible(false);
		if (ChartGenerateConstant.DISPLAY_DOMAIN_GRIDLINE) {
			plot.setDomainGridlinesVisible(true);
			plot.setDomainGridlinePaint(ChartGenerateConstant.DOMAIN_GRIDLINE_PAINT);
		}
	}

	/**
	 * 构建各点的tooltipGenerator
	 * 
	 * @param lineChartPara
	 * @return
	 */
	private CategoryToolTipGenerator buildCategoryToolTipGenerator(final JFreeChart chart,
			final LineChartPara chartPara) {
		return new CategoryToolTipGenerator() {
			public String generateToolTip(CategoryDataset dataset, int row, int column) {
				StringBuilder result = new StringBuilder();
				int rowCount = dataset.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					result.append(dataset.getRowKey(i));
					result.append("(").append(dataset.getColumnKey(column)).append("):");
					result.append(dataset.getValue(i, column));
					if (i != rowCount - 1) {
						result.append(StringUtil.getNewLine()).append(StringUtil.getNewLine());
					}
				}
				return result.toString();
			}
		};
	}

	/**
	 * 获取JFreeChart的Renderer
	 * 
	 * @param chart
	 * @return
	 */
	private LineAndShapeRenderer getChartRender(JFreeChart chart) {
		return (LineAndShapeRenderer) chart.getCategoryPlot().getRenderer();
	}

}
