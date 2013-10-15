package com.web.things.springioc.factory;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import com.web.things.springioc.FirstIoc;

/**
 * @author songjz 
 * @time 2013年10月9日
 */
public class SpringFactory2Test {

	@Test
	public void test_bean_is_not_null() {
		Object obj = SpringFactory2.getBean("firstIoc");
		assertNotNull(obj);
		FirstIoc ioc = SpringFactory2.getBean("firstIoc", FirstIoc.class);
		assertNotNull(ioc);
	}

	@Test(expected = NoSuchBeanDefinitionException.class)
	public void test_bean_is_null() {
		Object obj = SpringFactory2.getBean("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertNull(obj);
	}

}
