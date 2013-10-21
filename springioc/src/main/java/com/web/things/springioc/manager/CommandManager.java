package com.web.things.springioc.manager;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.web.things.springioc.Command;

public class CommandManager implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	protected Command createCommand() {
		return this.applicationContext.getBean("command", Command.class);
	}

	public Object process(Map<String, String> commandState) {
		// grab a new instance of the appropriate Command
		Command command = createCommand();
		// set the state on the (hopefully brand new) Command instance
		command.setState(commandState);
		return command.execute();
	}

}
