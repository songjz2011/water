/*
 * UserValidateSqliteDemoConnectRequest.java
 * Copyright: Copyright TsingSoft (c) 2014
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.connect.sqlite.demo;

import android.content.Context;

import com.tsingsoft.android.data.demo.InitSqliteDemoData;
import com.tsingsoft.android.entity.UserValidate;
import com.tsingsoft.android.server.connect.ConnectRequest;
import com.tsingsoft.android.server.exception.SearchException;
import com.tsingsoft.android.server.search.ServerSearch;

/**
 * <pre>
 * 用户验证 - demo使用Sqlite - 连接服务器端的请求
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月24日
 */
public class UserValidateSqliteDemoConnectRequest implements ConnectRequest {

	@SuppressWarnings("unchecked")
	public <T> T search(ServerSearch<T> search, Context context) throws SearchException {
		return (T) buildClientEntity(InitSqliteDemoData.DEMO_USER_NAME,
				InitSqliteDemoData.DEMO_USER_NAME);
	}

	private UserValidate buildClientEntity(String username, String password) {
		UserValidate userValidate = new UserValidate();
		userValidate.setUserName(username);
		userValidate.setPassWord(password);
		userValidate.setSuccess(true);
		return userValidate;
	}

}
