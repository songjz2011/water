package com.design.model.adapter;

/**
 * <pre>
 * 球员--中锋
 * </pre>
 * 
 * @author songjz
 * @time 2014年3月3日
 */
public class CenterPlayer extends Player {

	public CenterPlayer(String name) {
		super(name);
	}

	public void attack() {
		System.out.println("中锋 " + name + " 进攻");
	}

	public void defense() {
		System.out.println("中锋 " + name + " 防守");
	}

}
