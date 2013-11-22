package com.web.things.springioc.factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringFactoryAnnotation {

	private static AnnotationConfigApplicationContext context;

	static {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.web");
		context.refresh();
	}

	public static Object getBean(String id) {
		return context.getBean(id);
	}

	public static <T> T getBean(String id, Class<T> requiredType) {
		return context.getBean(id, requiredType);
	}

	public static <T> T getBean(Class<T> requiredType) {
		return context.getBean(requiredType);
	}

}
