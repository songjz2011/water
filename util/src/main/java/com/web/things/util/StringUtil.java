package com.web.things.util;

/**
 * String的工具类
 * 
 * @author songjz
 * @time 2013年7月25日
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
		if (obj == null || "".equals(obj.toString().trim())
				|| "null".equalsIgnoreCase(obj.toString().trim())) {
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
	 * 获取新行
	 * 
	 * @return
	 */
	public static String getNewLine() {
		return System.getProperty("line.separator");
	}

	/**
	 * 去除参数的出现的所有空格，若参数为null或者长度为空，返回自身
	 * 
	 * @param str
	 * @return
	 */
	public static String trimAllWhitespace(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		int index = 0;
		while (sb.length() > index) {
			if (Character.isWhitespace(sb.charAt(index))) {
				sb.deleteCharAt(index);
			} else {
				index++;
			}
		}
		return sb.toString();
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

}
