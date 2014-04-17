/*
 * UserValidateSearch.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.search;

import java.util.HashMap;
import java.util.Map;

import com.tsingsoft.android.entity.UserValidate;

/**
 * <pre>
 * 用户验证查询
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月17日
 */
public class UserValidateSearch extends AbstractServerSearch<UserValidate> {

	/** 用户登录名 */
	private String userName;

	/** 用户密码 */
	private String passWord;

	public ServerSearchCondition buildSearchCondition() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", getUserName());
		map.put("password", getPassWord());
		ServerSearchCondition serverSearchCondition = new ServerSearchCondition();
		serverSearchCondition.setAssistInfo(map);
		return serverSearchCondition;
	}

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

}
