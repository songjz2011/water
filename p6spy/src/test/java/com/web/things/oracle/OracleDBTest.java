package com.web.things.oracle;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

/**
 * 链接oracle数据库Test
 * 
 * @author songjz
 * @time 2013年8月6日
 */
public class OracleDBTest {

	@Test
	public void conn_should_not_be_null() {
		Connection conn = OracleDB.getConnection();
		assertNotNull(conn);
		OracleDB.closeConnetion(conn);
	}
	
}
