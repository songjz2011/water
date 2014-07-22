package com.web.things.util;

import java.util.List;

/**
 * <pre>
 * 查询sql的工具类
 * </pre>
 * 
 * @author songjz
 * @time 2014年7月17日
 */
public class QueryUtil {
	/**
	 * 构造字符串类型的IN查询条件
	 * 
	 * @param fieldValues
	 *            ：查询的字段值
	 * @param fieldName
	 *            ：查询的字段名称
	 * @return
	 */
	public static String buildInCondition(List<String> fieldValues, String fieldName) {
		return buildObjectInCondition(fieldValues, fieldName);
	}

	/**
	 * 构造number类型的IN查询条件
	 * 
	 * @param fieldValues
	 *            ：查询的字段值
	 * @param fieldName
	 *            ：查询的字段名称
	 * @return
	 */
	public static String buildNumberInCondition(List<? extends Number> fieldValues, String fieldName) {
		return buildObjectInCondition(fieldValues, fieldName);
	}

	private static String buildObjectInCondition(List<?> fieldValues, String fieldName) {
		if (fieldValues == null || fieldValues.isEmpty()) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		result.append("(");
		int size = fieldValues.size();
		int division = size / 1000;
		for (int i = 0; i <= division; i++) {
			int begin = i * 1000;
			if (begin >= size) {
				break;
			}
			int end = (i + 1) * 1000;
			if (end > size) {
				end = size;
			}
			if (i != 0) {
				result.append(" or ");
			}
			result.append(fieldName).append(" in (");
			result.append(buildQueryFieldValue(fieldValues.subList(begin, end)));
			result.append(") ");
		}
		result.append(")");
		return result.toString();
	}

	/**
	 * 构造字段值得字符串，结果如：'a','b','c'或者a,b,c
	 * 
	 * @param fieldValues
	 *            ：字段值
	 * @return
	 */
	private static String buildQueryFieldValue(List<?> fieldValues) {
		StringBuilder builder = new StringBuilder();
		for (Object value : fieldValues) {
			if (value instanceof String) {
				builder.append(",'").append(value).append("'");
			} else if (value instanceof Number) {
				builder.append(",").append(value);
			}
		}
		return builder.toString().substring(1);
	}
}
