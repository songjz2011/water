package com.web.things.easymock;

import java.sql.ResultSet;
import java.sql.Statement;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalesOrderImplTest {
	@Test
	public void test() {
		IMocksControl control = EasyMock.createControl();
		control.reset();
		ResultSet mockResultSet = control.createMock(ResultSet.class);
		/*
		 * 在生成 Mock 对象和设定 Mock 对象行为两个阶段，Mock 对象的状态都是 Record 。在这个阶段，Mock
		 * 对象会记录用户对预期行为和输出的设定
		 */
		try {
			/*
			 * mock设置 rs的next方法，用于 while (mockResultSet.next())
			 */
			mockResultSet.next();
			// mock三行数据
			EasyMock.expectLastCall().andReturn(true).times(3);
			// 三行之后，结束循环
			EasyMock.expectLastCall().andReturn(false).times(1);

			/*
			 * mock设置 第一列的数据
			 */
			mockResultSet.getString(1);
			EasyMock.expectLastCall().andReturn("DEMO_ORDER_001").times(1);
			EasyMock.expectLastCall().andReturn("DEMO_ORDER_002").times(1);
			EasyMock.expectLastCall().andReturn("DEMO_ORDER_003").times(1);
			/*
			 * mock设置 第二列的数据
			 */
			mockResultSet.getString(2);
			EasyMock.expectLastCall().andReturn("Asia Pacific").times(1);
			EasyMock.expectLastCall().andReturn("Europe").times(1);
			EasyMock.expectLastCall().andReturn("America").times(1);
			/*
			 * mock设置 第三列的数据
			 */
			mockResultSet.getDouble(3);
			EasyMock.expectLastCall().andReturn(350.0).times(1);
			EasyMock.expectLastCall().andReturn(1350.0).times(1);
			EasyMock.expectLastCall().andReturn(5350.0).times(1);

			/*
			 * Mock 对象的状态切换为 Replay，用于获取mock的值
			 */
			control.replay();

			int i = 0;
			String[] orderNumbers = { "DEMO_ORDER_001", "DEMO_ORDER_002", "DEMO_ORDER_003" };
			while (mockResultSet.next()) {
				SalesOrder order = new SalesOrderImpl();
				String orderNumber = order.loadDataFromDB(mockResultSet);
				assertEquals(orderNumber, orderNumbers[i]);
				i++;
			}

			/*
			 * 对 Mock 对象的方法调用的次数进行验证
			 */
			control.verify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test1() {
		IMocksControl control = EasyMock.createControl();
		control.reset();
		Statement mockStatement = control.createMock(Statement.class);
		ResultSet mockResultSet = control.createMock(ResultSet.class);
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
