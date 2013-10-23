package com.web.things.springioc;

import java.util.Map;

public class Command {

	private Map<String, String> state;
	
	private String name;
	
	public Object execute() {
		String result = "";
		if(name != null) {
			result += name;
		}
		result += "  Command.execute()...";
		System.out.println(result);
		return this;
	}

	public Map<String, String> getState() {
		return state;
	}

	public void setState(Map<String, String> state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
