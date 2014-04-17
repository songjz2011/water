package com.tsingsoft.android.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * 数字类型工具类
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月10日
 */
public class NumberUtil {
	public static DecimalFormat df = new DecimalFormat("0.00");

	public static final int LOAD_PRECISION = 2;

	/**
	 * 转成Double
	 * 
	 * @param obj
	 * @return
	 */
	public static Double convertToDouble(Object obj) {
		if (StringUtil.isEmpty(obj)) {
			return null;
		}
		try {
			return Double.valueOf(obj.toString());
		} catch (Exception e) {
		}
		return null;
	}

	public static String formatDouble(Double d) {
		if (d == null) {
			return "";
		}
		return df.format(d);
	}

	/**
	 * <pre>
	 * 减法（first-second）
	 * 若参数其中一个值为NULL，则返回NULL
	 * </pre>
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static Double reduce(Double first, Double second) {
		if (first == null || second == null) {
			return null;
		}
		return first - second;
	}

	/**
	 * <pre>
	 * 除法，若其中一个为null，返回null；若dividend为0，返回null
	 * </pre>
	 * 
	 * @param divisor
	 *            :除数
	 * @param dividend
	 *            ：被除数
	 * @return
	 */
	public static Double divide(Double divisor, Double dividend) {
		if (divisor == null || dividend == null || dividend == 0) {
			return null;
		}
		return divisor / dividend;
	}

	/**
	 * 获取Double集合中最大的数，若都为null，则返回null
	 * 
	 * @param list
	 * @return
	 */
	public static Double max(List<Double> list) {
		if (list == null || list.isEmpty() || isAllNull(list)) {
			return null;
		}
		List<Double> newList = new ArrayList<Double>();
		for (Double value : list) {
			if (value != null) {
				newList.add(value);
			}
		}
		return Collections.max(newList);
	}

	/**
	 * 获取Double集合中最小的数，若都为null，则返回null
	 * 
	 * @param list
	 * @return
	 */
	public static Double min(List<Double> list) {
		if (list == null || list.isEmpty() || isAllNull(list)) {
			return null;
		}
		List<Double> newList = new ArrayList<Double>();
		for (Double value : list) {
			if (value != null) {
				newList.add(value);
			}
		}
		return Collections.min(newList);
	}

	/**
	 * 是否所有的值都为空，若都为空，则返回true
	 * 
	 * @param list
	 * @return
	 */
	private static boolean isAllNull(List<? extends Object> list) {
		boolean isAllNull = true;
		if (list == null || list.isEmpty()) {
			return isAllNull;
		}
		for (Object value : list) {
			if (value != null) {
				isAllNull = false;
				break;
			}
		}
		return isAllNull;
	}

	/**
	 * 获取默认精度（小数点保留两位）的NumberFormat实例
	 * 
	 * @return
	 */
	public static NumberFormat getNumberFormat() {
		return getNumberFormat(LOAD_PRECISION);
	}

	/**
	 * 返回指定精度的NumberFormat实例.
	 * 
	 * @param p
	 *            要保留小数点的位数.
	 * @return NumberFormat 根据参数值设定了格式的NumberFormat实例对象.
	 */
	public static NumberFormat getNumberFormat(int p) {
		NumberFormat format = NumberFormat.getInstance();
		format.setMaximumFractionDigits(p);
		format.setMinimumFractionDigits(p);
		format.setGroupingUsed(false);
		return format;
	}
}
