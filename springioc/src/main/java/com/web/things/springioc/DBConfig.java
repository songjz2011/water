package com.web.things.springioc;

/**
 * <pre>
 * 数据库配置，用于测试 spring的PropertyPlaceholderConfigurer
 * </pre>
 * 
 * @author songjz
 * @time 2013年11月5日
 */
public class DBConfig {

	private String driverClass;
	
	private String user;
	
	private String passWord;

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
