/*
 * UserDao.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.entity.db.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.tsingsoft.android.entity.User;

/**
 * <pre>
 * 用户dao
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月16日
 */
public class UserDao {

	private static final String TABLE_NAME = "USER";

	public UserDao(Context context) {
	}

	/**
	 * 获取表中存储的所有用户
	 */
	public List<User> findAll() {
		List<User> result = new ArrayList<User>();
		return result;
	}

	/**
	 * 获取默认的用户(即当前登录用户)
	 */
	public User findDefalutUser() {
		User user = null;
		return user;
	}

	/**
	 * 根据用户名查询，若存在:返回User，不存在：返回null
	 * 
	 * @param userName
	 * @return
	 */
	public User findUser(String userName) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT NAME, PASSWORD, EMAIL FROM ").append(TABLE_NAME);
		sql.append(" WHERE NAME='").append(userName).append("' ");
		User user = null;
		return user;
	}

	/**
	 * 插入用户，默认使其为默认用户
	 * 
	 * @param userName
	 * @param password
	 */
	public void insertUser(String userName, String password) {
	}

	/**
	 * 更新当前登录用户密码
	 */
	public void updateDefalutUserPassword(String userName, String password) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ").append(TABLE_NAME);
		sql.append(" SET PASSWORD = '").append(password).append("',");
		sql.append(" ISDEFAULT = '1'");
		sql.append(" WHERE NAME='").append(userName).append("' ");
	}

	/**
	 * 更新当前登录用户的email
	 */
	public void updateDefalutUserEmail(String email) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ").append(TABLE_NAME);
		sql.append(" SET EMAIL = '").append(email).append("'");
		sql.append(" WHERE ISDEFAULT = '1' ");
	}

	/**
	 * 更新所有用户为不是默认的
	 */
	public void updateAllUserIsNotDefalut() {
		String sql = "UPDATE " + TABLE_NAME + " SET ISDEFAULT = '0'";
	}
}
