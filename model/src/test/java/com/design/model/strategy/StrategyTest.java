package com.design.model.strategy;

import org.junit.Test;

public class StrategyTest {

	@Test
	public void strategy_test() {
		CashContext cash = CashFactory.createCashContext(CashEnum.NORMAL);
		System.out.println(cash.getResult(100d));
	}
	
}
