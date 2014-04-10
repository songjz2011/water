package com.web.things.easymock;

import java.sql.ResultSet;

import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;
import org.easymock.IMocksControl;

public class EasyMockFirst {

	public static void main(String[] args) throws Exception {
		// IMockBuilder<ResultSet> mb =
		// EasyMock.createMockBuilder(ResultSet.class);
		// ResultSet rs = mb.createMock();
		IMocksControl control = EasyMock.createControl();
		ResultSet mockResultSet = control.createMock(ResultSet.class);
		
		mockResultSet.getString(1);
		IExpectationSetters<String> ies = EasyMock.expectLastCall();
		ies.andReturn("My return value");
		
		
	}

}
