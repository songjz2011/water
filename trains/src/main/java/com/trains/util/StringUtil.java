package com.trains.util;

public class StringUtil {

	/**
	 * 判断是否为空，为空则返回true<br>
	 * 为空的条件：null、""、"null"
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}
		String s = str.trim();
		if ("".equals(s) || "null".equalsIgnoreCase(s)) {
			return true;
		}
		return false;
	}

}
