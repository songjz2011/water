package com.web.things.util;

import org.slf4j.LoggerFactory;

public class LoggerUtil {
	private LoggerUtil() {
	}

	public static void warn(Class<?> clazz, String message) {
		LoggerFactory.getLogger(clazz).warn(message);
	}

	public static void debug(Class<?> clazz, String message) {
		LoggerFactory.getLogger(clazz).debug(message);
	}

	public static void info(Class<?> clazz, String message) {
		LoggerFactory.getLogger(clazz).info(message);
	}

	public static void error(Class<?> clazz, String message) {
		LoggerFactory.getLogger(clazz).error(message);
	}

	public static void error(Class<?> clazz, String message, Throwable t) {
		LoggerFactory.getLogger(clazz).error(message, t);
	}

	public static void error(String name, Throwable t) {
		LoggerFactory.getLogger(name).error(t.getMessage(), t);
	}
}
