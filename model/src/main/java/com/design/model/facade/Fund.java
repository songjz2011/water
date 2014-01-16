package com.design.model.facade;

/**
 * <pre>
 * 外观者模式 - 基金
 * </pre>
 * 
 * @author songjz
 * @time 2014年1月16日
 */
public class Fund {
	private Stock1 stock1;
	private Stock2 stock2;

	public Fund() {
		this.stock1 = new Stock1();
		this.stock2 = new Stock2();
	}

	public void buyFund() {
		this.stock1.buy();
		stock2.buy();
	}

	public void sellFund() {
		stock1.sell();
		stock2.sell();
	}
}
