package com.web.things.springioc;

/**
 * 静态单例
 * 
 * @author songjz
 * @time 2013年10月12日
 */
public class SingletonClass {

	private static SingletonClass obj = new SingletonClass();

	private SingletonClass() {
	}

	public static SingletonClass getInstance() {
		return obj;
	}

}
