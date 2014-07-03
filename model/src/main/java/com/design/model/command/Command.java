package com.design.model.command;

/**
 * <pre>
 * 抽象命令
 * </pre>
 * 
 * @author songjz
 * @time 2014年7月1日
 */
public abstract class Command {

	/**
	 * 个数
	 */
	private int num;

	/**
	 * 命令名称
	 */
	public abstract String getName();

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void excute() {
		System.out.println("执行" + getName() + "--" + getNum());
	}
}
