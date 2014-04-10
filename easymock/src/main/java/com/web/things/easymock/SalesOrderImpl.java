package com.web.things.easymock;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesOrderImpl implements SalesOrder {

	public String loadDataFromDB(ResultSet resultSet) throws SQLException {
		String orderNumber = resultSet.getString(1);
		String region = resultSet.getString(2);
		Double totalPrice = resultSet.getDouble(3);
		
		System.out.println("----------------------------");
		System.out.println(orderNumber);
		System.out.println(region);
		System.out.println(totalPrice);
		
		return orderNumber;
	}

	public String getPriceLevel() {
		return null;
	}

}
