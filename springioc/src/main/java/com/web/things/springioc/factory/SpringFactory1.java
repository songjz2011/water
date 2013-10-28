package com.web.things.springioc.factory;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.web.things.springioc.ObjectContainerDestroyCallbacks;

/**
 * @author songjz
 * @time 2013年9月30日
 */
public class SpringFactory1 {

	private static AbstractApplicationContext context;

	static {
		context = new ClassPathXmlApplicationContext(new String[] { "spring.xml" });
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

	public static void main(String[] args) {
		ObjectContainerDestroyCallbacks bean = SpringFactory
				.getBeanByDefaultId(ObjectContainerDestroyCallbacks.class);
		context.registerShutdownHook();
		System.out.println("bean.isDestroy() = " + bean.isDestroy());
	}

}
