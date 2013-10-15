package com.web.things.db.driver.monitor.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.web.things.db.driver.monitor.DBDriverSqlMonitorPreparedStatement;
import com.web.things.db.driver.monitor.DBDriverSqlMonitorStatement;

/**
 * @author songjz
 * @time 2013年8月7日
 */
public class DBDriverSqlMonitorFactory implements IDBDriverFactory {

	public Connection getConnection(Connection conn) throws SQLException {
		return new DBDriverSqlMonitorConnection(this, conn);
	}

	public Statement createStatement(Statement statement) throws SQLException {
		return new DBDriverSqlMonitorStatement(statement);
	}

	public PreparedStatement createPreparedStatement(PreparedStatement statement, String sql)
			throws SQLException {
		return new DBDriverSqlMonitorPreparedStatement(statement, sql);
	}

}
