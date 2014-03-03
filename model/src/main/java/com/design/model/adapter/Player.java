package com.design.model.adapter;

/**
 * <pre>
 * 球员抽象类
 * </pre>
 * 
 * @author songjz
 * @time 2014年3月3日
 */
public abstract class Player {

	protected String name;

	public Player(String name) {
		this.name = name;
	}

	/**
	 * 进攻
	 */
	public abstract void attack();

	/**
	 * 防守
	 */
	public abstract void defense();

}
