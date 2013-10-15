package com.web.things.springioc;

/**
 * 循环依赖测试对象1
 * @author songjz
 * @time 2013年10月14日
 */
public class CircularDependencyClass1 {

	private int id;

	private CircularDependencyClass2 class2;
	
	public void print() {
		System.out.println(CircularDependencyClass1.class.getSimpleName() + " : print...");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CircularDependencyClass2 getClass2() {
		return class2;
	}

	public void setClass2(CircularDependencyClass2 class2) {
		this.class2 = class2;
	}
}
