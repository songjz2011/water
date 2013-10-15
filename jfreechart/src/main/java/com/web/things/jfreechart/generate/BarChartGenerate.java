package com.web.things.jfreechart.generate;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import com.web.things.jfreechart.BarChartPara;
import com.web.things.jfreechart.BasicChartPara;
import com.web.things.jfreechart.exception.ChartParaTypeMismatchingException;

/**
 * <pre>
 * 柱状图形生成类
 * </pre>
 * 
 * @author songjz
 * @time 2013年8月3日
 */
public class BarChartGenerate extends AbstractChartGenerate {

	private static BarChartGenerate bar = new BarChartGenerate();

	private BarChartGenerate() {
	}

	public static BarChartGenerate getInstance() {
		return bar;
	}

	@Override
	protected void validateChartParaType(BasicChartPara chartPara)
			throws ChartParaTypeMismatchingException {
		if (!(chartPara instanceof BarChartPara)) {
			throw new ChartParaTypeMismatchingException("chart para mismatching bar...");
		}
	}

	public JFreeChart chartGender(BasicChartPara chartPara) throws Exception {
		validateChartParaType(chartPara);
		BarChartPara barChartPara = (BarChartPara) chartPara;
		CategoryDataset dataset = buildDataSet(barChartPara);
		JFreeChart chart = ChartFactory.createBarChart(chartPara.getTitle(),
				barChartPara.getDomainAxisLabel(), barChartPara.getRangeAxisLabel(), dataset,
				PlotOrientation.VERTICAL, true, true, false);

		// 设置JFreeChart的样式
		setChartStyle(chart, barChartPara);
		return chart;
	}

	/**
	 * 设置JFreeChart的样式
	 * 
	 * @param chart
	 * @param lineChartPara
	 */
	private void setChartStyle(JFreeChart chart, BarChartPara barChartPara) {
		setChartBasicStyle(chart, barChartPara);
	}

}
