/*
 * InitDemoData.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.data.demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import android.content.Context;
import com.tsingsoft.android.entity.LfCtrlNet;
import com.tsingsoft.android.entity.User;
import com.tsingsoft.android.entity.UserValidate;
import com.tsingsoft.android.entity.db.dao.LfCtrlNetDao;
import com.tsingsoft.android.entity.db.dao.UserDao;
import com.tsingsoft.android.util.StringUtil;

/**
 * <pre>
 * 初始化Demo使用Sqlite默认数据
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月24日
 */
public class InitSqliteDemoData {

	public static final String DEMO_USER_NAME = "admin";

	/**
	 * 初始化Demo数据
	 * 
	 * @param context
	 * @param userValidate
	 */
	public static void initDemoData(Context context, UserValidate userValidate) {
		// 初始化表
		initDataBaseTable(context);
		// 初始化表内容
		initDataTableContent(context, userValidate);

		LfCtrlNetDao netDao = new LfCtrlNetDao(context);
		List<LfCtrlNet> netList = netDao.findUserNet(DEMO_USER_NAME);
		userValidate.setNetList(netList);
		handleGlobalNets(context, netList);
	}

	private static void initDataBaseTable(Context context) {
		excuteSqlFile(context, "SqliteDemoInitTable.sql");
	}

	/**
	 * 初始化表内容
	 * 
	 * @param context
	 * @param userValidate
	 */
	private static void initDataTableContent(Context context, UserValidate userValidate) {
		if (!isNeedInitDataTableContent(context)) {
			return;
		}
		excuteSqlFile(context, "SqliteDemoInitData.sql");
		excuteSqlFile(context, "SqliteDemo96LcInitData.sql");
		excuteSqlFile(context, "SqliteDemo96LcSubmitInitData.sql");
		excuteSqlFile(context, "SqliteDemoAmend96lcSubmitInitTable.sql");
		excuteSqlFile(context, "SqliteDemoStHisFactorData.sql");
		
	}

	private static void excuteSqlFile(Context context, String fileName) {
	}

	/**
	 * 是否需要初始化表内容（若需要，返回true）
	 * 
	 * @param context
	 * @return
	 */
	private static boolean isNeedInitDataTableContent(Context context) {
		UserDao dao = new UserDao(context);
		User user = dao.findDefalutUser();
		if (user == null) {
			return true;
		}
		return false;
	}

	/**
	 * 是否读取行内容
	 * 
	 * @param lineContent
	 * @return
	 */
	private static boolean isReadSqlLine(String lineContent) {
		if (StringUtil.isEmpty(lineContent)) {
			return false;
		}
		if (lineContent.trim().startsWith("--")) {
			return false;
		}
		return true;
	}

	/**
	 * 把单位存放到全局中。
	 * 
	 * @param context
	 * @param netList
	 */
	private static void handleGlobalNets(Context context, List<LfCtrlNet> netList) {
	}
}
