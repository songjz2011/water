package com.web.things.jfreechart.generate;

import com.web.things.jfreechart.BarChartPara;
import com.web.things.jfreechart.BasicChartPara;
import com.web.things.jfreechart.LineChartPara;

/**
 * <pre>
 * 图表生成器factory
 * </pre>
 * 
 * @author songjz
 * @time 2013年8月1日
 */
public class ChartGenerateFactory {

	private ChartGenerateFactory() {
	}

	public static IChartGenerate generate(BasicChartPara chartPara) throws Exception {
		if (chartPara instanceof LineChartPara) {
			return LineChartGenerate.getInstance();
		} else if (chartPara instanceof BarChartPara) {
			return BarChartGenerate.getInstance();
		}
		throw new RuntimeException("ChartGenerateFactory can't find ChartGenerate...");
	}

}
