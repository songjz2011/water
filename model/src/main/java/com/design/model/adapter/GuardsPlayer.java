package com.design.model.adapter;

/**
 * <pre>
 * 球员--后卫
 * </pre>
 * 
 * @author songjz
 * @time 2014年3月3日
 */
public class GuardsPlayer extends Player {

	public GuardsPlayer(String name) {
		super(name);
	}

	public void attack() {
		System.out.println("后卫 " + name + " 进攻");
	}

	public void defense() {
		System.out.println("后卫 " + name + " 防守");
	}

}
