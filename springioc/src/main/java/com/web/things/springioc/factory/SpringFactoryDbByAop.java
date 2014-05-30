package com.web.things.springioc.factory;

import java.util.Locale;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * <pre>
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2014年5月30日
 */
public class SpringFactoryDbByAop {
	private static AbstractApplicationContext context;

	private static Locale locale;

	static {
		ClassLoader loader = SpringFactoryDbByAop.class.getClassLoader();
		String contextPath = loader.getResource("spring-context-annotation.xml").getPath();
		String contextPath1 = loader.getResource("db-aop.xml").getPath();
		context = new FileSystemXmlApplicationContext(new String[] { contextPath, contextPath1 });
		locale = Locale.US;
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

	/**
	 * 国际化
	 * 
	 * @param code
	 * @return
	 */
	public static String getMessage(String code) {
		return context.getMessage(code, null, null, locale);
	}

	/**
	 * 国际化
	 * 
	 * @param code
	 * @param args
	 *            ：参数
	 * @return
	 */
	public static String getMessage(String code, Object[] args) {
		return context.getMessage(code, args, "", locale);
	}

	public static Locale getLocale() {
		return locale;
	}
}
