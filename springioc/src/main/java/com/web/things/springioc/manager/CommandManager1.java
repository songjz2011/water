package com.web.things.springioc.manager;

import java.util.Map;

import com.web.things.springioc.Command;

public abstract class CommandManager1 {

	public abstract Command createCommand();
	
	public Object process(Map<String, String> commandState) {
		// grab a new instance of the appropriate Command
		Command command = createCommand();
		// set the state on the (hopefully brand new) Command instance
		command.setState(commandState);
		return command.execute();
	}

}
