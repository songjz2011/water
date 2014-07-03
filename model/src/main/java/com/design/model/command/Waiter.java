package com.design.model.command;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 服务员
 * </pre>
 * 
 * @author songjz
 * @time 2014年7月1日
 */
public class Waiter {

	/**
	 * 订单
	 */
	private List<Command> orders = new ArrayList<Command>();

	public void addOrder(Command command) {
		orders.add(command);
		System.out.println("增加订单--" + command.getName());
	}

	public void cancelOrder(Command command) {
		orders.remove(command);
		System.out.println("取消订单--" + command.getName());
	}

	public void placeOrder() {
		for (Command order : orders) {
			order.excute();
		}
	}

}
