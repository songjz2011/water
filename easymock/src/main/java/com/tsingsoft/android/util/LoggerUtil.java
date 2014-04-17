/*
 * LoggerUtil.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.util;


/**
 * <pre>
 * 日志工具对象
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月10日
 */
public class LoggerUtil {

	public static void error(Class<?> clazz, String message) {
	}

	public static void error(Class<?> clazz, Throwable e) {
	}

	public static void error(String tag, String message) {
	}

	public static void debug(Class<?> clazz, String message) {
	}

	public static void debug(Class<?> clazz, Throwable e) {
		parseLog(e);
	}

	public static void debug(String tag, String message) {
	}

	/**
	 * 将指定的异常信息转换成字符串。
	 * 
	 * @param e
	 * @return String
	 */
	private static String parseLog(Throwable e) {
		StringBuilder log = new StringBuilder();
		log.append(getNewLine() + "    " + e.toString());
		StackTraceElement[] els = e.getStackTrace();
		for (StackTraceElement el : els) {
			log.append(getNewLine() + "        at " + el);
		}
		return log.toString();
	}

	private static String getNewLine() {
		return StringUtil.getNewLine();
	}
}
