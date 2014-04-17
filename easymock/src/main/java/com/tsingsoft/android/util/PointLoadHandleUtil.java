package com.tsingsoft.android.util;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.tsingsoft.android.common.SysConstant;

/**
 * <pre>
 * 时刻点值处理的工具类
 * </pre>
 * 
 * @author songjz
 * @time 2013-12-10
 */
public class PointLoadHandleUtil {

	/**
	 * <pre>
	 * 去除null（以空字串替代），若不是null，则保留两位小数
	 * 并且时刻点的格式T0000转换成00:00
	 * 
	 * <pre>
	 * @param pointValueMap
	 * @return
	 */
	public static TreeMap<String, Object> killNullAndFormatKeyValue(Map<String, ?> pointValueMap) {
		Map<String, ?> valueMap = pointValueMap;
		if (valueMap == null || valueMap.isEmpty()) {
			valueMap = buildEmpty96PointValueMap();
		}
		TreeMap<String, Object> result = new TreeMap<String, Object>();
		NumberFormat format = NumberUtil.getNumberFormat();
		for (Entry<String, ?> entry : valueMap.entrySet()) {
			String key = entry.getKey();
			result.put(convertPointTimeKey(key), numberFormatValue(entry.getValue(), format));
		}
		return result;
	}

	/**
	 * 只去除null（以空字串替代），并且时刻点的格式T0000转换成00:00
	 * 
	 * @param pointValueMap
	 * @return
	 */
	public static TreeMap<String, Object> killNullAndFormatKey(Map<String, Object> pointValueMap) {
		TreeMap<String, Object> result = new TreeMap<String, Object>();
		if (pointValueMap == null || pointValueMap.isEmpty()) {
			return result;
		}
		for (Entry<String, Object> entry : pointValueMap.entrySet()) {
			String key = entry.getKey();
			result.put(convertPointTimeKey(key), killEmpty(entry.getValue()));
		}
		return result;
	}

	/**
	 * 构造空字串的96点负荷数据map
	 */
	private static TreeMap<String, Object> buildEmpty96PointValueMap() {
		String[] points = SysConstant.DAY_LOAD_CURVE_96COLUMN;
		TreeMap<String, Object> result = new TreeMap<String, Object>();
		for (String point : points) {
			result.put(point, "");
		}
		return result;
	}

	/**
	 * 构造空字串的96点负荷数据list
	 */
	public static List<String> buildEmpty96PointValueList() {
		String[] points = SysConstant.DAY_LOAD_CURVE_96COLUMN;
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < points.length; i++) {
			result.add("");
		}
		return result;
	}

	/**
	 * 格式化数据
	 * 
	 * @param value
	 * @param format
	 * @return
	 */
	public static Object numberFormatValue(Object value, NumberFormat format) {
		if (StringUtil.isEmpty(value)) {
			return "";
		}
		try {
			return format.format(Double.valueOf(value.toString().trim()));
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 去除空值，若是空则返回“”，不是则返回原始值
	 * 
	 * @param obj
	 * @return
	 */
	private static Object killEmpty(Object obj) {
		if (StringUtil.isEmpty(obj)) {
			return "";
		}
		return obj;
	}

	/**
	 * 转换时刻点，若是T1000，转成10:00
	 * 
	 * @param pointTime
	 * @return
	 */
	public static String convertPointTimeKey(String pointTime) {
		if (!pointTime.startsWith("T")) {
			return pointTime;
		}
		return pointTime.substring(1, 3) + ":" + pointTime.substring(3);
	}
}
