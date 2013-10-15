package com.web.things.db.driver.monitor.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author songjz
 * @time 2013年8月7日
 */
public interface IDBDriverFactory {

	Connection getConnection(Connection conn) throws SQLException;

	Statement createStatement(Statement statement) throws SQLException;

	PreparedStatement createPreparedStatement(PreparedStatement statement, String sql)
			throws SQLException;

}
