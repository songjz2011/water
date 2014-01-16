package com.design.model.prototype;

import com.web.things.util.LoggerUtil;
import com.web.things.util.StringUtil;

/**
 * <pre>
 * 原型模式 - 简历
 * </pre>
 * 
 * @author songjz
 * @time 2014年1月15日
 */
public class Resume implements Cloneable {
	private String name;
	private String sex;
	private String age;

	private WorkExprience workExprience;

	public Resume(String name) {
		this.name = name;
		workExprience = new WorkExprience();
	}

	public void setPersonalInfo(String sex, String age) {
		this.sex = sex;
		this.age = age;
	}

	public void setWorkExprience(String timeArea, String company) {
		workExprience.setTimeArea(timeArea);
		workExprience.setCompany(company);
	}

	public void display() {
		StringBuilder str = new StringBuilder();
		str.append(name).append(" ").append(sex).append(" ").append(age);
		str.append("  ");
		str.append("工作经历：").append(workExprience.getTimeArea()).append(" ")
				.append(workExprience.getCompany());
		str.append(StringUtil.getNewLine());
		System.out.println(str.toString());
	}

	public Resume clone() {
		Resume obj = null;
		try {
			obj = (Resume) super.clone();
			obj.workExprience = workExprience.clone();
		} catch (CloneNotSupportedException e) {
			LoggerUtil.error(getClass(), e);
		}
		return obj;
	}
}
