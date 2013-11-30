package com.web.things.jfreechart.generate;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.web.things.jfreechart.BasicChartPara;
import com.web.things.jfreechart.ChartData;
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
public class LineChartGenerate extends AbstractChartGenerate {
	private static LineChartGenerate line = new LineChartGenerate();

	private LineChartGenerate() {
	}

	public static LineChartGenerate getInstance() {
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
		XYDataset dataset = buildDataSet(lineChartPara);
		JFreeChart chart = ChartFactory.createXYLineChart(chartPara.getTitle(),
				lineChartPara.getDomainLabel(), lineChartPara.getRangeLabel(), dataset,
				PlotOrientation.VERTICAL, true, true, false);
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
	 * @param lineChartPara
	 */
	@SuppressWarnings("deprecation")
	private void setLineStyle(JFreeChart chart, LineChartPara lineChartPara) {
		XYLineAndShapeRenderer renderer = getChartRender(chart);
		// 设置是否显示曲线中各点的图形 默认为显示
		renderer.setBaseShapesVisible(lineChartPara.isShapesVisible());
		// 设置各点的tooltip
		if (lineChartPara.isShapesToolTipVisible()) {
			renderer.setShape(new RoundRectangle2D.Float(-2.0f, -2.0f, 4.0f, 4.0f, 2.0f, 2.0f));
			renderer.setBaseToolTipGenerator(buildXYToolTipGenerator(chart));
		}
		// 设置各线的颜色
		setLineColor(chart, lineChartPara);
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
		XYLineAndShapeRenderer renderer = getChartRender(chart);
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
		XYPlot plot = chart.getXYPlot();
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
		XYPlot plot = chart.getXYPlot();
		String[] domainAxisSymbols = chartPara.getDomainAxisSymbols();
		if (domainAxisSymbols == null || domainAxisSymbols.length == 0) {
			// 每个数据点在x轴的名称 不显示
			plot.getDomainAxis().setTickLabelsVisible(false);
			return;
		}
		// 设置数据点在X轴显示名称
		if (domainAxisSymbols.length < SymbolAxis.MAXIMUM_TICK_COUNT) {
			SymbolAxis domainAxis = new SymbolAxis(chartPara.getDomainLabel(), domainAxisSymbols);
			domainAxis.setGridBandsVisible(false);
			plot.setDomainAxis(domainAxis);
		}
		// 设置显示名称是否纵向展示
		plot.getDomainAxis().setTickLabelFont(ChartGenerateConstant.DEFAULT_VALUE_LABEL_FONT);
		Integer verticalDTLN = chartPara.getVerticalDTLN();
		if (verticalDTLN != null && verticalDTLN < domainAxisSymbols.length) {
			plot.getDomainAxis().setVerticalTickLabels(true);
			plot.getDomainAxis().setTickLabelFont(ChartGenerateConstant.SMALL_FONT);
		}
	}

	/**
	 * 设置网格线的样式
	 * 
	 * @param chart
	 */
	private void setGridlineStyle(JFreeChart chart) {
		XYPlot plot = chart.getXYPlot();
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
	 * 构造line的数据
	 * 
	 * @param chartPara
	 * @return
	 */
	private XYDataset buildDataSet(LineChartPara chartPara) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		List<ChartData> list = chartPara.getChartDataList();
		if (list == null || list.isEmpty()) {
			return dataset;
		}
		for (int i = 0; i < list.size(); i++) {
			if (i > 30) {
				break;
			}
			ChartData chartData = list.get(i);
			List<String> dataList = chartData.getDataList();
			if (dataIsEmpty(dataList)) {
				continue;
			}
			XYSeries series = new XYSeries(getLengendName(chartData, i));
			for (int j = 0; j < dataList.size(); j++) {
				String data = dataList.get(j);
				Number value = null;
				if (!StringUtil.isEmpty(data)) {
					value = Double.parseDouble(data.trim());
				}
				series.add(j, value);
			}
			dataset.addSeries(series);
		}
		return dataset;
	}

	/**
	 * 图例的名称
	 * 
	 * @param chartData
	 * @return
	 */
	private String getLengendName(ChartData chartData, int index) {
		String lengendName = StringUtil.trim(chartData.getLegendName());
		if (StringUtil.isEmpty(lengendName)) {
			lengendName = String.valueOf(index);
		}
		return lengendName;
	}

	/**
	 * 构建各点的tooltipGenerator
	 * 
	 * @param lineChartPara
	 * @return
	 */
	private XYToolTipGenerator buildXYToolTipGenerator(final JFreeChart chart) {
		return new XYToolTipGenerator() {
			public String generateToolTip(XYDataset dataset, int series, int item) {
				StringBuilder result = new StringBuilder();
				int seriesCount = dataset.getSeriesCount();
				for (int i = 0; i < seriesCount; i++) {
					// 每个数据点在x轴显示的名称
					String domainName = dataset.getX(i, item).toString();
					XYPlot plot = chart.getXYPlot();
					ValueAxis valueAxis = plot.getDomainAxis();
					if (valueAxis instanceof SymbolAxis) {
						SymbolAxis symbolAxis = (SymbolAxis) valueAxis;
						String[] symbols = symbolAxis.getSymbols();
						domainName = symbols[item];
					}
					result.append(dataset.getSeriesKey(i));
					result.append("(").append(domainName).append("):");
					result.append(dataset.getYValue(i, item));
					if (i != seriesCount - 1) {
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
	private XYLineAndShapeRenderer getChartRender(JFreeChart chart) {
		return (XYLineAndShapeRenderer) chart.getXYPlot().getRenderer();
	}

}
