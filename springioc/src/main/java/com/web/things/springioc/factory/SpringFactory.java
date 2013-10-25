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
		String contextManagerPath = loader.getResource("spring-manager.xml").getPath();
		context = new FileSystemXmlApplicationContext(new String[] { contextPath, contextStudyPath,
				contextDaoPath, contextManagerPath });
	}

	public static Object getBean(String id) {
		return context.getBean(id);
	}

	public static <T> T getBean(String id, Class<T> requiredType) {
		return context.getBean(id, requiredType);
	}

	/**
	 * 根据对象 默认定义的Id（为对象名称，首字母为小写），获取对象
	 * @param requiredType
	 * @return
	 */
	public static <T> T getBeanByDefaultId(Class<T> requiredType) {
		String id = getDefaultId(requiredType);
		return getBean(id, requiredType);
	}

	/**
	 * 获取在spring容器中，默认定义的id:为对象名称（首字母为小写）
	 * 
	 * @param cl
	 * @return
	 */
	private static String getDefaultId(Class<?> cl) {
		String name = cl.getSimpleName();
		name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
		return name;
	}

}
