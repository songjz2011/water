package com.design.model.strategy;

/**
 * <pre>
 * 策略 - 上下文 - 生成的工厂
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月5日
 */
public class CashFactory {
	public static CashContext createCashContext(CashEnum type) {
		CashSuper cash = null;
		switch (type) {
		case NORMAL:
			cash = new CashNormal();
			break;
		case RATE:
			cash = new CashRate(0.8);
			break;
		case RETURN:
			cash = new CashReturn("300", "100");
			break;
		default:
			cash = new CashNormal();
			break;
		}
		CashContext context = new CashContext(cash);
		return context;
	}
}
