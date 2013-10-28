package com.web.things.springioc;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class CustomScope implements Scope {

	public Object get(String name, ObjectFactory<?> objectFactory) {
		return null;
	}

	public Object remove(String name) {
		return null;
	}

	public void registerDestructionCallback(String name, Runnable callback) {

	}

	public Object resolveContextualObject(String key) {
		return null;
	}

	public String getConversationId() {
		return "customScopeTest";
	}

}
