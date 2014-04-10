package com.web.things.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	private Object obj;

	public LogHandler(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object result = method.invoke(obj, args);
		return result;
	}

	private void before() {
		System.out.println("调用方法之前");
	}
}
