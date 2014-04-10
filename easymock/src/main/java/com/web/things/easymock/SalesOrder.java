package com.web.things.easymock;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SalesOrder {
	public String loadDataFromDB(ResultSet resultSet) throws SQLException;

	public String getPriceLevel();
}
