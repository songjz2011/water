package com.design.model.beaninfo;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * <pre>
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2014年7月17日
 */
public class IntrospectorBeanInfo {

	private String name;

	private String id;
	
	public Object getBlNextMonthLogPropertyValue(Object log, String propertyName) {
		Object result = null;
		try {
			System.out.println(log.getClass().getName());
			BeanInfo beanInfo = Introspector.getBeanInfo(log.getClass());
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor descriptor : descriptors) {
				if (!propertyName.equals(descriptor.getName())) {
					continue;
				}
				Method method = descriptor.getReadMethod();
				System.out.println(method.invoke(log));
				//System.out.println(descriptor.getValue(propertyName));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
