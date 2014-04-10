package com.web.things.dynamic.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class DynamicProxyTest {

	@Test
	public void test() {
		Hello h = new HelloImp();
		LogHandler handler = new LogHandler(h);
		Hello hello = (Hello)Proxy.newProxyInstance(h.getClass().getClassLoader(), h.getClass()
				.getInterfaces(), handler);
		hello.say("张三");
	}
}
