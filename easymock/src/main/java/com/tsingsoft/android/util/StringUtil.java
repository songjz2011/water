package com.tsingsoft.android.util;

/**
 * String的工具类
 * 
 * @author songjz
 * @time 2013-12-9
 */
public class StringUtil {

	/**
	 * 判断是否为空，为空则返回true<br>
	 * 为空的条件：null、""、"null"
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		String str = obj.toString().trim();
		if ("".equals(str) || "null".equalsIgnoreCase(str)) {
			return true;
		}
		return false;
	}

	/**
	 * 若字符串为空（参见isEmpty方法），返回""；<br>
	 * 若不为空，则返回自身(去除前后空格)
	 * 
	 * @param str
	 * @return
	 */
	public static String trim(Object str) {
		if (isEmpty(str)) {
			return "";
		}
		return str.toString().trim();
	}

	/**
	 * 若字符串为空（参见isEmpty方法），返回defaultValue；<br>
	 * 若不为空，则返回自身(去除前后空格)
	 * 
	 * @param str
	 * @return
	 */
	public static String trim(Object str, String defaultValue) {
		if (isEmpty(str)) {
			return defaultValue;
		}
		return str.toString().trim();
	}

	/**
	 * 获取新行
	 * 
	 * @return
	 */
	public static String getNewLine() {
		return System.getProperty("line.separator");
	}

}
