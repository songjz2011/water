package com.web.things.db;

import java.sql.Connection;

import static org.junit.Assert.*;
import org.junit.Test;

public class DBFactoryTest {

	@Test
	public void test_oracle() {
		DBService service = DBFactory.getDBService();
		Connection conn = service.getConnection();
		assertNotNull(conn);
	}
	
}
