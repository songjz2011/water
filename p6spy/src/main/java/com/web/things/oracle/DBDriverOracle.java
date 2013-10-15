package com.web.things.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author songjz
 * @time 2013年8月7日
 */
public class DBDriverOracle {
	
	private final static String DRIVER_URL = "jdbc:oracle:thin:@localhost:1521:oracle";

	private final static String DRIVER = "com.web.things.db.driver.DBDriver";

	private final static String USERNAME = "warn";

	private final static String PASSWORD = "warn";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DRIVER_URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnetion(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
