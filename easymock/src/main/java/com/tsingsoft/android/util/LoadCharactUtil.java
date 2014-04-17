package com.tsingsoft.android.util;


import java.text.DecimalFormat;
import java.util.List;

/**
 * <pre>
 * 负荷特性工具类
 * </pre>
 * 
 * @author songjz
 * @time 2013-12-18
 */
public class LoadCharactUtil {

	static DecimalFormat df = new DecimalFormat("########0.00"); 
	/**
	 * 最大负荷，返回值没有进行小数点处理
	 * 
	 * @param loadList
	 * @return
	 */
	public static Double maxLoad(List<Double> loadList) {
		return NumberUtil.max(loadList);
	}

	/**
	 * 最小负荷，返回值没有进行小数点处理
	 * 
	 * @param loadList
	 * @return
	 */
	public static Double minLoad(List<Double> loadList) {
		return NumberUtil.min(loadList);
	}
	

	/**
	 * <pre>
	 * 平均值，若有值为null，则该点不计算在内
	 * 返回值逻辑：
	 * 1、是null，返回null；
	 * 2、不是null，没有进行小数点处理
	 * </pre>
	 * 
	 * @param loadList
	 * @return
	 */
	public static Double avgLoad(List<Double> loadList) {
		Double result = null;
		if (loadList == null || loadList.isEmpty()) {
			return result;
		}
		double count = 0d;
		double num = 0d;
		for (Double load : loadList) {
			if (load == null) {
				continue;
			}
			count++;
			num += load;
		}
		if (count != 0) {
			result = num / count;
		}
		return Double.parseDouble(df.format(result));
	}

	/**
	 * <pre>
	 * 负荷率（计算公式:平均负荷/最大负荷）
	 * 返回值逻辑：
	 * 1、是null，返回null；
	 * 2、不是null，乘以100（即返回值为百分比），没有进行小数点处理
	 * </pre>
	 * 
	 * @param loadList
	 * @return
	 */
	public static Double loadRate(List<Double> loadList) {
		Double avgLoad = avgLoad(loadList);
		Double maxLoad = maxLoad(loadList);
		Double result = NumberUtil.divide(avgLoad, maxLoad);
		if (result != null) {
			result = result * 100;
		}
		return result;
	}

	/**
	 * <pre>
	 * 峰谷差（计算公式：最大负荷-最小负荷）
	 * 1、若最大负荷or最低负荷为null，则返回null
	 * 2、返回值没有进行小数点处理
	 * </pre>
	 * 
	 * @param loadList
	 * @return
	 */
	public static Double difference(List<Double> loadList) {
		Double maxLoad = maxLoad(loadList);
		Double minLoad = minLoad(loadList);
		return NumberUtil.reduce(maxLoad, minLoad);
	}

	/**
	 * <pre>
	 * 峰谷差率（计算公式：峰谷差/最大负荷）
	 * 1、若峰谷差or最大负荷为null，则返回null
	 * 2、返回值没有进行小数点处理，已经乘以100（即返回值为百分比）
	 * </pre>
	 * 
	 * @param loadList
	 * @return
	 */
	public static Double differenceRate(List<Double> loadList) {
		Double difference = difference(loadList);
		Double maxLoad = maxLoad(loadList);
		Double result = NumberUtil.divide(difference, maxLoad);
		if (result != null) {
			result = result * 100;
		}
		return result;
	}

}
