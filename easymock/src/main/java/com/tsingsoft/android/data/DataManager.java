package com.tsingsoft.android.data;

import android.content.Context;

import com.tsingsoft.android.data.demo.ClearSqliteDemoData;
import com.tsingsoft.android.data.demo.InitSqliteDemoData;
import com.tsingsoft.android.entity.UserValidate;
import com.tsingsoft.android.server.connect.ConnectRequest;
import com.tsingsoft.android.server.connect.ConnectRequestSqliteDemoFactory;
import com.tsingsoft.android.server.search.ServerSearch;

/**
 * <pre>
 * 数据管理对象
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月16日
 */
public class DataManager {

	/**
	 * 查询数据
	 * 
	 * @param serverSearch
	 *            ：查询对象
	 * @param context
	 *            ：上下文
	 * @return
	 */
	public static <T> T search(ServerSearch<T> serverSearch, Context context) {
		T obj = null;
		try {
			// ConnectRequest request =
			// ConnectRequestFactory.create(serverSearch);
			ConnectRequest request = ConnectRequestSqliteDemoFactory.create(serverSearch);
			obj = request.search(serverSearch, context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 初始化默认数据
	 * 
	 * @param context
	 *            ：上下文
	 * @param userName
	 *            ：用户名
	 * @param password
	 *            ：密码
	 */
	public static void initDefaultData(Context context, UserValidate userValidate) {
		// InitDefalutData.initDefalutData(context, userValidate);
		InitSqliteDemoData.initDemoData(context, userValidate);
	}

	/**
	 * 清除数据
	 */
	public static void clearData(Context context) {
		// ClearDefalutData.clearData(context);
		ClearSqliteDemoData.clearData(context);
	}

}
