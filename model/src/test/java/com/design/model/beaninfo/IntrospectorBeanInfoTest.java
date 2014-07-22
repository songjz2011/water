package com.design.model.beaninfo;

import org.junit.Test;

/**
 * <pre>类描述</pre>
 * @author songjz 
 * @time 2014年7月17日
 */
public class IntrospectorBeanInfoTest {

	@Test
	public void test() {
		IntrospectorBeanInfo info = new IntrospectorBeanInfo();
		info.setId("22222");
		info.setName("我是谁");
		info.getBlNextMonthLogPropertyValue(info, "name");
	}
	
}
