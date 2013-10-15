package com.web.things.springioc;

/**
 * @author songjz
 * @time 2013年10月12日
 */
public class ExampleBean {

	private int id;

	private String name;

	public ExampleBean() {

	}

	public ExampleBean(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
