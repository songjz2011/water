package com.web.things.springioc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.web.things.springioc.factory.SpringFactory;

public class ObjectContainerInitCallbacksTest {

	@Test
	public void afterPropertiesSet_is_true() {
		ObjectContainerInitCallbacks bean = SpringFactory.getBean("objectContainerInitCallbacks",
				ObjectContainerInitCallbacks.class);
		assertTrue(bean.isAfterPropertiesSet());
	}
	
	@Test
	public void init_is_true() {
		ObjectContainerInitCallbacks bean = SpringFactory.getBean("objectContainerInitCallbacks",
				ObjectContainerInitCallbacks.class);
		assertTrue(bean.isInit());
	}
	

}
