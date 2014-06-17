package com.design.model.combination;

/**
 * <pre>
 * 在组合中，表示叶子节点对象，叶子节点没有子节点
 * </pre>
 */
public class Leaf extends Component {

	public Leaf(String name) {
		super(name);
	}

	public void add(Component c) {
		System.out.println("Cannot add to a leaf");
	}

	public void remove(Component c) {
		System.out.println("Cannot remove from a leaf");
	}

	public void display(int depth) {
		System.out.println(name + "-" + depth);
	}

}
