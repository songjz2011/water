package com.web.things.springioc.factory;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * <pre>
 * FileSystemXmlApplicationContext和ClassPathXmlApplicationContext的区别
 * 1、根据 文件的路径 加载xml文件的：
 * 没有盘符的是项目工作路径，即项目的根目录，例如：new FileSystemXmlApplicationContext("spring.xml")；
 * 有盘符表示的是文件绝对路径，例如：FileSystemXmlApplicationContext("D:/project/spring.xml")；
 * 注意：如果要使用classpath路径,需要前缀classpath，例如：new FileSystemXmlApplicationContext("classpath:spring.xml")；
 * 
 * 2、ClassPathXmlApplicationContext，是根据classpath路径加载xml文件的；
 * 默认是根据 classpath加载，例如：new ClassPathXmlApplicationContext(new String[] { "spring.xml" })
 * 							或者用通配符同时加载多个配置文件ClassPathXmlApplicationContext("classpath*:/*.xml")；
 * 注意：如果要使用file路径，需要前缀file，例如new ClassPathXmlApplicationContext(new String[] { "file:spring.xml" }
 * 
 * 备注：
 * classpath单个文件和多个文件的区别
 * 单个文件：FileSystemXmlApplicationContext("classpath:spring.xml")
 * 多个文件：FileSystemXmlApplicationContext("classpath*:spring*.xml")
 * 			或者　FileSystemXmlApplicationContext("classpath*:/spring*.xml")
 * 
 * </pre>
 * 
 * @author songjz
 * @time 2013年9月30日
 */
public class SpringFactory {

	//private static ApplicationContext context;
	
	private static AbstractApplicationContext context;

	static {
//		ClassLoader loader = SpringFactory.class.getClassLoader();
//		String contextPath = loader.getResource("spring-context.xml").getPath();
//		String contextStudyPath = loader.getResource("spring-context-study.xml").getPath();
//		String contextDaoPath = loader.getResource("spring-context-dao.xml").getPath();
//		String contextManagerPath = loader.getResource("spring-manager.xml").getPath();
//		String contextCustomPath = loader.getResource("spring-context-custom.xml").getPath();
//		context = new FileSystemXmlApplicationContext(new String[] { contextPath, contextStudyPath,
//				contextDaoPath, contextManagerPath, contextCustomPath });
		
		context = new FileSystemXmlApplicationContext("classpath*:spring*.xml");
	}

	public static AbstractApplicationContext getContext() {
		return context;
	}

	public static Object getBean(String id) {
		return context.getBean(id);
	}

	public static <T> T getBean(String id, Class<T> requiredType) {
		return context.getBean(id, requiredType);
	}

	/**
	 * 根据对象 默认定义的Id（为对象名称，首字母为小写），获取对象
	 * 
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
