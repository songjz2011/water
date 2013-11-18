package com.web.things.springioc;

import org.junit.Test;

import com.web.things.springioc.factory.SpringFactory;

public class ObjectContainerDestroyCallbacksTest {

	@Test
	public void test() {
		ObjectContainerDestroyCallbacks bean = SpringFactory
				.getBeanByDefaultId(ObjectContainerDestroyCallbacks.class);
		SpringFactory.getContext().registerShutdownHook();
		System.out.println("bean.isDestroy() = " + bean.isDestroy());
	}

}
