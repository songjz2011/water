package com.design.model.strategy;

import com.web.things.util.NumberUtil;

/**
 * <pre>
 * 返利 (例如：满300返100)- 计算价格类
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月5日
 */
public class CashReturn extends CashSuper {
	private double moneyCondition;

	private double moneyReturn;

	public CashReturn(String moneyCondition, String moneyReturn) {
		this.moneyCondition = NumberUtil.parseNumber(moneyCondition, Double.class);
		this.moneyReturn = NumberUtil.parseNumber(moneyReturn, Double.class);
	}

	public double acceptCash(double money) {
		double result = money;
		if (money >= moneyCondition) {
			result = money - Math.floor(money / moneyCondition) * moneyReturn;
		}
		return result;
	}

}
