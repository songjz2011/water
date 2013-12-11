package com.web.things.springioc.entity;

public class Company {
	private String name;
	/** 总经理 */
	private Employee managingDirector;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManagingDirector() {
		return managingDirector;
	}

	public void setManagingDirector(Employee managingDirector) {
		this.managingDirector = managingDirector;
	}
}
