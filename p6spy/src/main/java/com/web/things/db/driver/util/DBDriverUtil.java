package com.web.things.db.driver.util;

import java.net.URL;

/**
 * @author songjz
 * @time 2013年8月6日
 */
public class DBDriverUtil {

	public static String classPathFile(String fileName) {
		URL fileURL = DBDriverUtil.class.getClassLoader().getResource(fileName);
		return fileURL.getPath();
	}

	public static Class<?> forName(String name) throws ClassNotFoundException {
		return Class.forName(name);
	}

	public static void main(String[] args) {
		String fileName = "dbdriver.properties";
		DBDriverUtil.classPathFile(fileName);
	}
}
