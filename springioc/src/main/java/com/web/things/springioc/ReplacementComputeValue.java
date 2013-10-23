package com.web.things.springioc;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class ReplacementComputeValue implements MethodReplacer {

	public Object reimplement(Object o, Method m, Object[] args) throws Throwable {
		System.out.println("ReplacementComputeValue.reimplement");
		return null;
	}

}
