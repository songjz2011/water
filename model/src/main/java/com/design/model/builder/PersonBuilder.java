package com.design.model.builder;

import java.awt.Graphics;

/**
 * <pre>
 * 小人构造者
 * </pre>
 * 
 * @author songjz
 * @time 2014年1月22日
 */
public abstract class PersonBuilder {

	protected Graphics graphics;

	public PersonBuilder() {
	}

	public abstract void builderHead();

	public abstract void builderBody();

	public abstract void builderLeftArm();

	public abstract void builderRightArm();

	public abstract void builderLeftLeg();

	public abstract void builderRightLeg();

	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}

}
