package com.design.transaction;

import java.util.Date;

/**
 * <pre>
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2014年5月16日
 */
public class User {
	// 用户ID
	private String id;
	// 用户名称
	private String name;
	// 登陆密码
	private String password;
	// 联系电话
	private String contact_tel;
	// 电子邮件
	private String email;
	// 用户创建日期
	private Date create_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact_tel() {
		return contact_tel == null ? "" : contact_tel;
	}

	public void setContact_tel(String contact_tel) {
		this.contact_tel = contact_tel;
	}

	public String getEmail() {
		return email == null ? "" : email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}
