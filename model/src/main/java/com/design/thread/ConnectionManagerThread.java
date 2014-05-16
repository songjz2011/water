package com.design.thread;

import java.sql.Connection;
import java.sql.SQLException;

import javax.transaction.Transaction;

import org.apache.commons.dbcp.ConnectionFactory;

/**
 * <pre>
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2014年5月16日
 */
public class ConnectionManagerThread {

	private static final ThreadLocal<Connection> connection = new ThreadLocal<Connection>();

	private static ConnectionFactory factory;

	private static boolean initialized = false;

	private ConnectionManagerThread() {

	}

	private synchronized static void initialize() {
		try {
			// factory = new
			// Configuration().configure().buildConnectionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		initialized = true;
	}

	public static Connection curConnection() {
		if (initialized) {
			initialize();
		}
		Connection conn = connection.get();
		if (conn == null) {
			try {
				conn = factory.createConnection();
				connection.set(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static void closeConnection() {
		Connection conn = connection.get();
		connection.set(null);
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Transaction beginTransaction() {
		Connection conn = curConnection();
		// return new TransactionFactory().beginTransaction(conn);
		return null;
	}

}
