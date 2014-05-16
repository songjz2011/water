package com.web.things.db;

import java.io.InputStream;
import java.util.Properties;

import com.web.things.util.LoggerUtil;

public class DBFactory {

	private static DBService dbService;

	private static Properties properties;

	static {
		try {
			InputStream inStream = DBFactory.class.getClassLoader().getResourceAsStream(
					"db.properties");
			properties = new Properties();
			properties.load(inStream);
			String dbType = getPropertyValue("db.type");
			dbType = Character.toUpperCase(dbType.charAt(0)) + dbType.substring(1);
			String className = "com.web.things.db." + dbType + "Service";
			dbService = (DBService) Class.forName(className).newInstance();
			dbService.setProperties(properties);
		} catch (Exception e) {
			LoggerUtil.error(DBFactory.class, e);
		}
	}

	public static DBService getDBService() {
		return dbService;
	}

	private static String getPropertyValue(String key) {
		return properties.getProperty(key);
	}

}
