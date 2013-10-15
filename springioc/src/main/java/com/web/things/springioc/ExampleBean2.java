package com.web.things.springioc;

/**
 * @author songjz
 * @time 2013年10月12日
 */
public class ExampleBean2 {

	private int id;

	private String name;

	private String address;

	public ExampleBean2() {

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

	public void setDD(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
}
