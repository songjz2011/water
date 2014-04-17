package com.tsingsoft.android.entity;

/**
 * <pre>
 * 用户信息
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月13日
 */
public class User {

	/** 用户登录名 */
	private String userName;

	/** 用户密码，这里请设置用户输入的值，请求传输过程中会自动加密 */
	private String passWord;

	/** 用户的邮箱 */
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
