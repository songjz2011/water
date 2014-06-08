package com.web.things.webcms.entity;

/**
 * <pre>
 * 数据库实体 - 用户
 * </pre>
 * 
 * @author songjz
 * @time 2014年6月4日
 */

public class User {

	private Long id;

	private String name;
	
	private boolean canAccess;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCanAccess() {
		return canAccess;
	}

	public void setCanAccess(boolean canAccess) {
		this.canAccess = canAccess;
	}

}
