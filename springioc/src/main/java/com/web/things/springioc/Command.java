package com.web.things.springioc;

import java.util.Map;

public class Command {

	private Map<String, String> state;

	public Object execute() {
		System.out.println("Command.execute()...");
		return this;
	}

	public Map<String, String> getState() {
		return state;
	}

	public void setState(Map<String, String> state) {
		this.state = state;
	}

}
