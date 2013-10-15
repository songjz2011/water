package com.web.things.oracle;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

/**
 * @author songjz 
 * @time 2013年8月7日
 */
public class DBDriverOracleTest {
	@Test
	public void conn_should_not_be_null() {
		Connection conn = DBDriverOracle.getConnection();
		assertNotNull(conn);
		try {
			String sql = "update LF_CTRL_NET set NETID='00' where NETID='00'";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		OracleDB.closeConnetion(conn);
	}
}
