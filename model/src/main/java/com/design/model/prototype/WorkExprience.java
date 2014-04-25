package com.design.model.prototype;

import com.web.things.util.LoggerUtil;

/**
 * <pre>
 * 原型模式 - 工作经验
 * </pre>
 * 
 * @author songjz
 * @time 2014年1月15日
 */
public class WorkExprience implements Cloneable{
	private String timeArea;
	private String company;
	
	public WorkExprience clone() {
		try {
			return (WorkExprience) super.clone();
		} catch (CloneNotSupportedException e) {
			LoggerUtil.error(getClass(), "WorkExprience.clone", e);
		}
		return null;
	}

	public String getTimeArea() {
		return timeArea;
	}

	public void setTimeArea(String timeArea) {
		this.timeArea = timeArea;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
