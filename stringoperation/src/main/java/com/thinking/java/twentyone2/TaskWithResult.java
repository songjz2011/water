package com.thinking.java.twentyone2;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {

	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	public String call() throws Exception {
		return "result of TaskWithResult " + id;
	}

}
