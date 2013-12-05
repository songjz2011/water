package com.design.model.strategy;

/**
 * <pre>
 * 正常-计算价格类
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月4日
 */
public class CashNormal extends CashSuper {
	public double acceptCash(double money) {
		return money;
	}

}
