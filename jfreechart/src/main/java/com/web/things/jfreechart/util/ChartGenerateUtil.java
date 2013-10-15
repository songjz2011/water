package com.web.things.jfreechart.util;

import com.web.things.jfreechart.BasicChartPara;
import com.web.things.jfreechart.exception.ChartParaNullException;

/**
 * <pre>
 * 图形生成的工具类
 * </pre>
 * 
 * @author songjz
 * @time 2013年8月2日
 */
public class ChartGenerateUtil {

	/**
	 * 验证ChartPar是否为null，若为null则抛出异常
	 * 
	 * @param chartPara
	 * @throws ChartParaNullException
	 */
	public static void validateChartParaNull(BasicChartPara chartPara)
			throws ChartParaNullException {
		if (chartPara == null) {
			throw new ChartParaNullException();
		}
	}

}
