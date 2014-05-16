package com.design.transaction;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectFactory {

	private static Properties properties;

	private static String driverName;
	private static String driverUrl;
	private static String userName;
	private static String password;

	static {
		try {
			InputStream inStream = DBConnectFactory.class.getClassLoader().getResourceAsStream(
					"db.properties");
			properties = new Properties();
			properties.load(inStream);

			driverName = getPropertyValue("db.driver-class");
			driverUrl = getPropertyValue("db.driver-url");
			userName = getPropertyValue("db.user");
			password = getPropertyValue("db.password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getPropertyValue(String key) {
		return properties.getProperty(key);
	}

	public static Connection getConenction() {
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(driverUrl, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
