package com.web.things.springioc;

import org.junit.Before;

import com.web.things.springioc.factory.SpringFactory;

public class ObjectContainerDestroyCallbacksTest {

	private ObjectContainerDestroyCallbacks bean;

	@Before
	public void beforeEachMethod() {
		bean = SpringFactory.getBeanByDefaultId(ObjectContainerDestroyCallbacks.class);
		System.out.println(bean);
	}
	

}
