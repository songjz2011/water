package com.web.things.springioc.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author songjz
 * @time 2013年9月30日
 */
public class SpringFactory {

	private static ApplicationContext context;

	static {
		ClassLoader loader = SpringFactory.class.getClassLoader();
		String contextPath = loader.getResource("spring-context.xml").getPath();
		String contextStudyPath = loader.getResource("spring-context-study.xml").getPath();
		String contextDaoPath = loader.getResource("spring-context-dao.xml").getPath();
		context = new FileSystemXmlApplicationContext(new String[] { contextPath, contextStudyPath,
				contextDaoPath });
	}

	public static Object getBean(String id) {
		return context.getBean(id);
	}

	public static <T> T getBean(String id, Class<T> requiredType) {
		return context.getBean(id, requiredType);
	}

}
