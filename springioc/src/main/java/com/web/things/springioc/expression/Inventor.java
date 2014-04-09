package com.web.things.springioc.expression;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * spring 表达式语言 对象测试
 * </pre>
 * 
 * @author songjz
 * @time 2014年4月8日
 */
public class Inventor {

	private String name;

	private Date birthday;

	/**
	 * 国籍
	 */
	private String nationality;
	
	private List<String> list;
	
	private Map<String, String> map;
	
	public String hello(String str) {
		return "热烈欢迎啊: " + str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

}
