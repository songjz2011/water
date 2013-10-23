package com.web.things.springioc;

/**
 * @author songjz
 * @time 2013年8月15日
 */
public class FirstIoc {
	
	private FirstIocForPrototype prototype;

	public void print(String name) {
		System.out.println("hello  " + name + "....");
	}

	public FirstIocForPrototype getPrototype() {
		return prototype;
	}

	public void setPrototype(FirstIocForPrototype prototype) {
		this.prototype = prototype;
	}

}
