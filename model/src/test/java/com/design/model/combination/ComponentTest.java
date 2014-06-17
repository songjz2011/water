package com.design.model.combination;

import org.junit.Test;

/**
 * <pre>
 * 组合模式测试
 * </pre>
 */
public class ComponentTest {

	@Test
	public void test() {
		/*
		 * 生成树根root，根上长出俩叶 leaf A 和 Leaf B
		 */
		Composite root = new Composite("root");
		root.add(new Leaf("Leaf A"));
		root.add(new Leaf("Leaf B"));

		/*
		 * 根上长出分枝Composite x，分枝上也有俩叶 Leaf XA 和 Leaf XB
		 */
		Composite com = new Composite("Composite x");
		com.add(new Leaf("Leaf XA"));
		com.add(new Leaf("Leaf XB"));

		root.add(com);
		/*
		 * 在  Composite x上长出分枝Composite xy，分枝上也有俩叶 Leaf XYA 和 Leaf XYB
		 */
		Composite com2 = new Composite("Composite xy");
		com2.add(new Leaf("Leaf XYA"));
		com2.add(new Leaf("Leaf XYB"));

		com.add(com2);

		/**
		 * 根部又长出俩叶子 Leaf C 和 Leaf D，可惜Leaf D没长牢固，被风吹走了
		 */
		root.add(new Leaf("Leaf C"));
		Leaf leafD = new Leaf("Leaf D");
		root.add(leafD);
		root.remove(leafD);
		
		root.display(1);
	}

}
