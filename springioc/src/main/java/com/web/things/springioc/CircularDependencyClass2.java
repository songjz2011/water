package com.web.things.springioc;

/**
 * 循环依赖测试对象2
 * 
 * @author songjz
 * @time 2013年10月14日
 */
public class CircularDependencyClass2 {

	private int id;

	private CircularDependencyClass1 class1;

	public void print() {
		System.out.println(CircularDependencyClass2.class.getSimpleName() + " : print...");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CircularDependencyClass1 getClass1() {
		return class1;
	}

	public void setClass1(CircularDependencyClass1 class1) {
		this.class1 = class1;
	}

}
