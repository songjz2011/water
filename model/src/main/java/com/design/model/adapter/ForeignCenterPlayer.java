package com.design.model.adapter;

/**
 * <pre>
 * 球员--外籍 中锋
 * </pre>
 * 
 * @author songjz
 * @time 2014年3月3日
 */
public class ForeignCenterPlayer {

	private String name;

	public ForeignCenterPlayer(String name) {
		this.name = name;
	}

	/**
	 * 进攻
	 */
	public void jingong() {
		System.out.println("外籍中锋 " + name + " 进攻");
	}

	/**
	 * 防守
	 */
	public void fangshou() {
		System.out.println("外籍中锋 " + name + " 防守");
	}

	public String getName() {
		return name;
	}
}
