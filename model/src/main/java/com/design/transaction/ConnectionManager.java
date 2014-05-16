package com.design.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * <pre>
 * 设计模式之 动态代理 - ThreadLocal实现事务管理
 * 
 * ConnectionManager :数据库连接管理类,实现对数据库连接和事务的管理
 * </pre>
 * 
 * @author songjz
 * @time 2014年5月16日
 */
public class ConnectionManager {

	private static ThreadLocal<Connection> threadConn = new ThreadLocal<Connection>();

	private ConnectionManager() {
	}

	public static Connection getConnection() {
		Connection conn = threadConn.get();
		if (conn == null) {
			conn = DBConnectFactory.getConenction();
			threadConn.set(conn);
		}
		return conn;
	}

	public static void beginTransaction(Connection conn) {
		try {
			if (conn != null) {
				if (conn.getAutoCommit()) {
					conn.setAutoCommit(false);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 提交事务
	public static void endTransction(Connection conn) {
		try {
			if (conn != null) {
				if (!conn.getAutoCommit()) {
					conn.commit();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 设置Connection的原始状态
	public static void recoverTransction(Connection conn) {
		try {
			if (conn != null) {
				if (conn.getAutoCommit()) {
					conn.setAutoCommit(false);
				} else {
					conn.setAutoCommit(true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 发生异常回滚事务
	public static void rollback(Connection conn) {
		try {
			if (conn != null) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 关闭连接,并将其从当前线程删除
	public static void close() {
		Connection conn = threadConn.get();
		if (conn != null) {
			try {
				conn.close();
				conn = null;
				threadConn.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
