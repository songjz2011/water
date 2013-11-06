package com.web.things.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 日志工具类
 * </pre>
 * 
 * @author songjz
 */
public class LoggerUtil {
	private LoggerUtil() {
	}

	public static void warn(Class<?> clazz, Throwable t) {
		warn(clazz, parseLog(t));
	}

	public static void warn(Class<?> clazz, String message) {
		getLogger(clazz).warn(message);
	}

	public static void debug(Class<?> clazz, Throwable t) {
		debug(clazz, parseLog(t));
	}

	public static void debug(Class<?> clazz, String message) {
		getLogger(clazz).debug(message);
	}

	public static void info(Class<?> clazz, Throwable t) {
		info(clazz, parseLog(t));
	}

	public static void info(Class<?> clazz, String message) {
		getLogger(clazz).info(message);
	}

	public static void error(Class<?> clazz, Throwable t) {
		error(clazz, parseLog(t));
	}

	public static void error(Class<?> clazz, String message) {
		getLogger(clazz).error(message);
	}

	private static Logger getLogger(Class<?> clazz) {
		return LoggerFactory.getLogger(clazz);
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
