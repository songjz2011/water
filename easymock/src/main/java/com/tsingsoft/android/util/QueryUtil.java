package com.tsingsoft.android.util;

import java.util.List;

/**
 * <pre>
 * 查询sql的工具类
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月25日
 */
public class QueryUtil {

	/**
	 * 构造IN的查询条件
	 * 
	 * @param fieldValues
	 * @param fieldName
	 * @return
	 */
	public static String buildInCondition(List<String> fieldValues, String fieldName) {
		if (fieldValues.isEmpty()) {
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
	 * 构造字段值得字符串，结果如：'a','b','c'
	 * 
	 * @param fieldValues
	 * @return
	 */
	public static String buildQueryFieldValue(List<String> fieldValues) {
		StringBuilder builder = new StringBuilder();
		for (String value : fieldValues) {
			builder.append(",'").append(value).append("'");
		}
		return builder.toString().substring(1);
	}

	/**
	 * 构造字段值得字符串，结果如：'a','b','c'
	 * 
	 * @param fieldValues
	 * @return
	 */
	public static String buildQueryFieldValue(String[] fieldValues) {
		StringBuilder builder = new StringBuilder();
		for (String value : fieldValues) {
			builder.append(",'").append(value).append("'");
		}
		return builder.toString().substring(1);
	}
}
