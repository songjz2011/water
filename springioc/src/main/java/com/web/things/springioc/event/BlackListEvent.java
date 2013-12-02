package com.web.things.springioc.event;

import org.springframework.context.ApplicationEvent;

public class BlackListEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 837374685082115559L;
	private final String address;
	private final String test;

	public BlackListEvent(Object source, String address, String test) {
		super(source);
		this.address = address;
		this.test = test;
	}

	public String getAddress() {
		return address;
	}

	public String getTest() {
		return test;
	}
}
