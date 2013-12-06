package com.web.things.util;

/**
 * <pre>
 * 数据 - 类型的工具类
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月5日
 */
public class NumberUtil {

	public static Double convert(Object value) {
		Double result = null;
		try {
			if (!StringUtil.isEmpty(value)) {
				result = Double.valueOf(value.toString());
			}
		} catch (RuntimeException e) {
		}
		return result;
	}

}
