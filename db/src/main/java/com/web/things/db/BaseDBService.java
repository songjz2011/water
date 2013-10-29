package com.web.things.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.web.things.util.LoggerUtil;

public abstract class BaseDBService implements DBService {
	protected Properties properties;
	protected String driver;
	protected String url;
	protected String user;
	protected String password;

	public void setProperties(Properties properties) {
		this.properties = properties;
		driver = properties.getProperty("db.driver-class");
		url = properties.getProperty("db.driver-url");
		user = properties.getProperty("db.user");
		password = properties.getProperty("db.password");
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			LoggerUtil.error(getClass(), e);
		}
		return conn;
	}

	public void rollBack(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (Exception e) {
				LoggerUtil.error(getClass(), e);
			}
		}
	}

	public void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				LoggerUtil.error(getClass(), e);
			}
		}
	}

	public void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				LoggerUtil.error(getClass(), e);
			}
		}
	}

	public void close(Connection conn) {
		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				LoggerUtil.error(getClass(), e);
			}
		}
	}

	public void close(ResultSet rs, Statement stmt, Connection conn) {
		close(rs);
		close(stmt);
		close(conn);
	}

}
