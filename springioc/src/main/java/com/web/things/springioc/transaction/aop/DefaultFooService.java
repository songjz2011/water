package com.web.things.springioc.transaction.aop;

import org.springframework.stereotype.Service;

/**
 * <pre>
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2014年5月30日
 */
@Service
public class DefaultFooService implements FooService {

	public Foo getFoo(String fooName) {
		throw new UnsupportedOperationException();
	}

	public Foo getFoo(String fooName, String barName) {
		throw new UnsupportedOperationException();
	}

	public void insertFoo(Foo foo) {
		throw new UnsupportedOperationException();
	}

	public void updateFoo(Foo foo) {
		throw new UnsupportedOperationException();
	}
}
