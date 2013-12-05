package com.design.model.strategy;

/**
 * <pre>
 * 打折 - 计算价格类
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月4日
 */
public class CashRate extends CashSuper {

	private double rate = 1;

	public CashRate(double rate) {
		this.rate = rate;
	}

	public double acceptCash(double money) {
		return rate * money;
	}

}
