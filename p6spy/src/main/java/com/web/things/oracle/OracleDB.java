package com.web.things.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 链接oracle数据库
 * 
 * @author songjz
 * @time 2013年8月6日
 */
public class OracleDB {

	private final static String DRIVER_URL = "jdbc:oracle:thin:@localhost:1521:oracle";

	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";

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
