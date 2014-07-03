package com.design.model.command;

import org.junit.Test;

/**
 * <pre>
 * 服务员 测试
 * </pre>
 * 
 * @author songjz
 * @time 2014年7月1日
 */
public class WaiterTest {

	@Test
	public void test() {
		Waiter waiter = new Waiter();
		BakeMuttonCommand bm = new BakeMuttonCommand();
		bm.setNum(10);
		
		waiter.addOrder(bm);
		
		BakeChickenWingCommand bcm = new BakeChickenWingCommand();
		bcm.setNum(2);
		
		waiter.addOrder(bcm);
		
		waiter.placeOrder();
	}
	
}
