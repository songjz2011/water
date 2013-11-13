package com.web.things.springioc.annotation;

/**
 * <pre>
 * 电影格式
 * </pre>
 * 
 * @author songjz
 * @time 2013年11月11日
 */
public enum MovieFormat {

	VHS("1", "VHS"), DVD("2", "DVD"), BLURAY("3", "BLURAY");

	private String id;
	private String name;

	private MovieFormat(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
