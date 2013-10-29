package com.web.things.springioc;

import org.junit.Before;

import com.web.things.springioc.factory.SpringFactory;
import com.web.things.util.LoggerUtil;

public class ObjectContainerDestroyCallbacksTest {

	private ObjectContainerDestroyCallbacks bean;

	@Before
	public void beforeEachMethod() {
		bean = SpringFactory.getBeanByDefaultId(ObjectContainerDestroyCallbacks.class);
		LoggerUtil.info(this.getClass(), bean.toString());
	}
	

}
