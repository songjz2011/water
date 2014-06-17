package com.design.model.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 定义有枝节点行为，用来存储子部件，在Component接口中实现与子部件有关的操作；比如Add、Remove
 * </pre>
 */
public class Composite extends Component {
	private List<Component> children = new ArrayList<Component>();

	public Composite(String name) {
		super(name);
	}

	public void add(Component c) {
		children.add(c);
	}

	public void remove(Component c) {
		children.remove(c);
	}

	public void display(int depth) {
		System.out.println(name + "--" + depth);
		for (Component c : children) {
			c.display(depth + 2);
		}
	}

}
