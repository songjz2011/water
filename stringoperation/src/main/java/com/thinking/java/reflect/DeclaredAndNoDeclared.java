package com.thinking.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射中，getDeclared*和get*的区别，例如(getDeclaredAnnotation和getAnnotation)
 * 
 * @author songjz
 * 
 */
public class DeclaredAndNoDeclared {

	/**
	 * 指的是类自身所有的 属性，不包含继承的
	 * 
	 * @param cl
	 */
	public static void printDeclaredFields(Class<?> cl) {
		Field[] fields = cl.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}

	/**
	 * 指的是类自身、所有父类的public属性
	 * 
	 * @param cl
	 */
	public static void printFields(Class<?> cl) {
		Field[] fields = cl.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}

	/**
	 * 指的是类自身所有的 方法，不包含继承的
	 * 
	 * @param cl
	 */
	public static void printDeclaredMethods(Class<?> cl) {
		Method[] methods = cl.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}

	/**
	 * 指的是类自身、所有父类的public方法
	 * 
	 * @param cl
	 */
	public static void printMethods(Class<?> cl) {
		Method[] methods = cl.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}

	public static void main(String[] args) {
		// DeclaredAndNoDeclared.printDeclaredFields(WildGoose.class);
		// DeclaredAndNoDeclared.printFields(WildGoose.class);
		//DeclaredAndNoDeclared.printDeclaredMethods(WildGoose.class);
		DeclaredAndNoDeclared.printMethods(WildGoose.class);
	}

}
