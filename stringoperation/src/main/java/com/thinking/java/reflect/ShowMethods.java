package com.thinking.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import com.thinking.java.classtest.FildedList;

public class ShowMethods {

	private static String usage = "usage:\n"
			+ "ShowMethods qualified.class.name\n"
			+ "To show all methods in class or:\n"
			+ "ShowMethods qualified.class.name word\n"
			+ "To search for methods involving 'word'";

	private static Pattern p = Pattern.compile("\\w+\\.");
	
	public void show(String className) {
		int lines = 0;
		try {
			Class<?> c = Class.forName(className);
			Method[] methods = c.getMethods();
			for(Method method : methods) {
				//System.out.println(method.toString());
				System.out.println(p.matcher(method.toString()).replaceAll(""));
			}
			Constructor[] ctors = c.getConstructors();
			for(Constructor ctor : ctors) {
				System.out.println(p.matcher(ctor.toString()).replaceAll(""));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ShowMethods m1 = new ShowMethods();
		m1.show(FildedList.class.getName());
	}
}
