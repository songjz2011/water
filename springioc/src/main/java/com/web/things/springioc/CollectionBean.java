package com.web.things.springioc;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * <pre>
 * 集合的注入 - 测试bean
 * </pre>
 * 
 * @author songjz
 * @time 2013年10月17日
 */
public class CollectionBean {

	private Properties emails;

	private List<String> list;

	private Map<String, String> map;

	private Set<String> set;

	private String[] array;

	public Properties getEmails() {
		return emails;
	}

	public void setEmails(Properties emails) {
		this.emails = emails;
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

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

}
