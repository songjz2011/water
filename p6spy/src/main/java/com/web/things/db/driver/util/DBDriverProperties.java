package com.web.things.db.driver.util;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import com.web.things.db.driver.DBDriverOption;
import com.web.things.db.driver.monitor.manager.DBMonitorManager;

/**
 * 设置的属性值
 * 
 * @author songjz
 * @time 2013年8月6日
 */
public class DBDriverProperties {

	protected static Properties properties;

	protected static DBDriverOption dbDriverOption;

	protected static String SPY_PROPERTIES_FILE_NAME = "db_monitor_driver.properties";

	public static void init() {
		String propertiesPath = DBDriverUtil.classPathFile(SPY_PROPERTIES_FILE_NAME);
		File propertiesFile = new File(propertiesPath);
		if (!propertiesFile.exists()) {
			throw new RuntimeException("cann't find properties file");
		}
		try {
			properties = new Properties();
			FileInputStream in = new FileInputStream(propertiesPath);
			properties.load(in);
			in.close();
			initDBDriverOption();
			initDBMonitorManager();
		} catch (Exception e) {
			properties = null;
			dbDriverOption = null;
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	private static void initDBDriverOption() throws Exception {
		dbDriverOption = new DBDriverOption();
		Method[] methods = dbDriverOption.getClass().getDeclaredMethods();
		if (methods == null) {
			return;
		}
		for (Method method : methods) {
			String methodName = method.getName();
			if (!methodName.startsWith("set")) {
				continue;
			}
			String propertyName = methodName.substring(3).toLowerCase();
			String propertyValue = properties.getProperty(propertyName);
			method.invoke(dbDriverOption, new Object[] { propertyValue });
		}
	}

	private static void initDBMonitorManager() throws Exception {
		DBMonitorManager.init(dbDriverOption);
	}

	/**
	 * @return the properties
	 */
	public static Properties getProperties() {
		return properties;
	}

	/**
	 * @return the dbDriverOption
	 */
	public static DBDriverOption getDbDriverOption() {
		return dbDriverOption;
	}

}
