package com.web.things.util;

/**
 * String的工具类
 * 
 * @author songjz
 * @time 2013年7月25日
 */
public class StringUtil {

	/**
	 * 判断字符是否为空，为空则返回true<br>
	 * 为空的条件：null、""、"null"
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim()) || "null".equalsIgnoreCase(str.trim())) {
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
	public static String trim(String str) {
		if (isEmpty(str)) {
			return "";
		}
		return str.trim();
	}

	/**
	 * 在展示的时候，可能需要去掉字符串中的html标签，只展示无格式的字符，并且在字符的长度超一定值时使用......代替超出部分
	 * 
	 * @param input
	 *            : 输入需要展示的字符串
	 * @param length
	 *            : 该字符串的最大长度，如果超过长度时，添加.....
	 * @return
	 */
	public static String splitAndFilterString(String input, int length) {
		if (isEmpty(input)) {
			return "";
		}
		String str = input.replaceAll("<[a-zA-Z]+[1-9]?[^><]*>", "").replaceAll(
				"</[a-zA-Z]+[1-9]?>", "");
		str = str.replaceAll("[(/>)<]", "");
		int len = str.length();
		if (len <= length) {
			return str;
		} else {
			str = str.substring(0, length);
			str += "......";
		}
		return str;
	}

	public static String getNewLine() {
		return System.getProperty("line.separator");
	}

	/**
	 * 判断字符串是否为"1"or"true"
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isTrue(String str) {
		if (isEmpty(str)) {
			return false;
		}
		return "1".equals(str.trim()) || "true".equals(str.trim());
	}

}
