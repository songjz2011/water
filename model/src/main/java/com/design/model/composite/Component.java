package com.design.model.composite;

/**
 * <pre>
 * 抽象组件
 * </pre>
 * 
 * @author songjz
 * @time 2014年3月7日
 */
public abstract class Component {

	protected String name;

	public Component(String name) {
		this.name = name;
	}

	/**
	 * 添加组件（若此节点为父节点，则可以添加子节点）
	 * 
	 * @param c
	 */
	public abstract void add(Component c);

	public abstract void remove(Component c);

	/**
	 * 显示深度（即此节点在整个树中的层次）
	 * 
	 * @param depth
	 */
	public abstract void display(int depth);
}
