package com.design.model.composite;

/**
 * <pre>
 * 组件的叶子节点
 * </pre>
 * 
 * @author songjz
 * @time 2014年3月7日
 */
public class Leaf extends Component {

	public Leaf(String name) {
		super(name);
	}

	public void add(Component c) {
		System.out.println("Cannot add to a leaf...");
	}

	public void remove(Component c) {
		System.out.println("Cannot remove from a leaf...");
	}

	public void display(int depth) {
		System.out.println();
	}

}
