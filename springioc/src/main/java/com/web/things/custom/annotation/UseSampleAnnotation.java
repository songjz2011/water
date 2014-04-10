package com.web.things.custom.annotation;

import java.lang.reflect.Method;

@SampleAnnotation(value = "woami")
public class UseSampleAnnotation {
	
	public void parseMethod(Class<?> clazz){
		SampleAnnotation san = clazz.getAnnotation(SampleAnnotation.class);
		if (san != null) {
			String value = san.value();
			System.out.println(value);
		}
		for (Method method : clazz.getDeclaredMethods()) {
			SampleAnnotation sa = method.getAnnotation(SampleAnnotation.class);
			if (sa == null) {
				continue;
			}
			String value = sa.value();
			System.out.println(value);
		}
	}
	
	public static void main(String[] args) {
		UseSampleAnnotation an = new UseSampleAnnotation();
		an.parseMethod(UseSampleAnnotation.class);
	}

}
