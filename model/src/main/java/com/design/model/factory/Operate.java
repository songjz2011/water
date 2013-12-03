package com.design.model.factory;

/**
 * <pre>
 * 计算操作
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月3日
 */
public abstract class Operate {

	protected double numberA;

	protected double numberB;

	public abstract double getResult();

	public void setNumberA(double numberA) {
		this.numberA = numberA;
	}

	public void setNumberB(double numberB) {
		this.numberB = numberB;
	}
}
