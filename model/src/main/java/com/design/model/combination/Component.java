package com.design.model.combination;

/**
 * <pre>
 * 组合模式中的对象声明接口，在适当的情况下，实现所有类共有接口的默认行为。
 * 声明一个接口用于访问和管理子部件
 * </pre>
 */
public abstract class Component {

	protected String name;

	public Component(String name) {
		this.name = name;
	}

	public abstract void add(Component c);

	public abstract void remove(Component c);

	public abstract void display(int depth);

}
