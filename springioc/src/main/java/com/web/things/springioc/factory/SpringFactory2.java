package com.web.things.springioc.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author songjz
 * @time 2013年9月30日
 */
public class SpringFactory2 {

	private static ApplicationContext context;

	static {
		ClassLoader loader = SpringFactory2.class.getClassLoader();
		String contextPath = loader.getResource("spring.xml").getPath();
		context = new FileSystemXmlApplicationContext(new String[] { contextPath });

	}

	public static Object getBean(String name) {
		return context.getBean(name);
	}
	
	public static <T> T getBean(String name, Class<T> requiredType) {
		return context.getBean(name, requiredType);
	}

}
