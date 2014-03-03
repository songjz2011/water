package com.design.model.adapter;

/**
 * <pre>
 * 球员--前锋
 * </pre>
 * 
 * @author songjz
 * @time 2014年3月3日
 */
public class ForwardsPlayer extends Player {

	public ForwardsPlayer(String name) {
		super(name);
	}

	public void attack() {
		System.out.println("前锋 " + name + " 进攻");
	}

	public void defense() {
		System.out.println("前锋 " + name + " 防守");
	}

}
