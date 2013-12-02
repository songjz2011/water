package com.web.things.springioc.event;

import org.springframework.context.ApplicationEvent;

public class ApplicationEventInterceptor extends ApplicationEvent {

	private static final long serialVersionUID = 3369547423490404784L;

	public ApplicationEventInterceptor(Object source) {
		super(source);
	}

}
