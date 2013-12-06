package com.design.model.strategy;

/**
 * <pre>
 * 策略模式的上下文，用于调用具体策略的逻辑
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月5日
 */
public class CashContext {

	private CashSuper cash;

	public CashContext(CashSuper cash) {
		this.cash = cash;
	}

	public double getResult(double money) {
		return cash.acceptCash(money);
	}

}
