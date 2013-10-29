package com.web.things.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public interface DBService {
	void setProperties(Properties properties);
	
	Connection getConnection();
	
	void rollBack(Connection conn);

	void close(ResultSet rs);

	void close(Statement stmt);

	void close(Connection conn);
	
	void close(ResultSet rs, Statement stmt, Connection conn);
}
