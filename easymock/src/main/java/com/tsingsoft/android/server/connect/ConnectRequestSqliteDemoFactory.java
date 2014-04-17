/*
 * ConnectRequestSqliteDemoFactory.java
 * Copyright: Copyright TsingSoft (c) 2014
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.connect;

import com.tsingsoft.android.server.ServerSearchConstant;

import com.tsingsoft.android.server.connect.sqlite.demo.LoadAnalyzeSqliteDemoConnectRequest;

import com.tsingsoft.android.server.connect.sqlite.demo.LoadCorrectionSqliteDemoConnectRequest;

import com.tsingsoft.android.server.connect.sqlite.demo.LoadCorrectionSubmitSqliteDemoRequest;



import com.tsingsoft.android.server.connect.sqlite.demo.LoadMonitorSqliteDemoConnectRequest;
import com.tsingsoft.android.server.connect.sqlite.demo.SystemDateSqliteDemoConnectRequest;
import com.tsingsoft.android.server.connect.sqlite.demo.UserValidateSqliteDemoConnectRequest;
import com.tsingsoft.android.server.connect.sqlite.demo.WeatherSqliteDemoConnectRequest;
import com.tsingsoft.android.server.exception.SearchException;
import com.tsingsoft.android.server.search.CorrectionSubmitSearch;
import com.tsingsoft.android.server.search.LoadAnalyzeSearch;
import com.tsingsoft.android.server.search.LoadCorrectionSearch;
import com.tsingsoft.android.server.search.LoadMonitorSearch;
import com.tsingsoft.android.server.search.ServerSearch;
import com.tsingsoft.android.server.search.SystemDateSearch;
import com.tsingsoft.android.server.search.UserValidateSearch;
import com.tsingsoft.android.server.search.WeatherSearch;

/**
 * <pre>
 * 创建连接工厂--demo使用Sqlite
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月24日
 */
public class ConnectRequestSqliteDemoFactory {
	/**
	 * 构造ConnectRequest
	 * 
	 * @param serverSearch
	 * @return
	 */
	public static <T> ConnectRequest create(ServerSearch<T> serverSearch) {
		ConnectRequestEnum type = getConnectRequestEnum(serverSearch);
		return create(type);
	}

	/**
	 * 根据枚举类型构造ConnectRequest
	 * 
	 * @param type
	 * @return
	 */
	private static ConnectRequest create(ConnectRequestEnum type) {
		if (type == null) {
			throw new SearchException(ServerSearchConstant.getMessage("server.object.error"));
		}
		ConnectRequest request = null;
		switch (type) {
		case LOADMONITOR:
			request = new LoadMonitorSqliteDemoConnectRequest();
			break;
		case USERVALIDATE:
			request = new UserValidateSqliteDemoConnectRequest();
			break;
		case LOADANALYZE:
			request = new LoadAnalyzeSqliteDemoConnectRequest();
			break;
		case LOADCORRECTION:
			request = new LoadCorrectionSqliteDemoConnectRequest();
			break;
		case WEATHER:
			request = new WeatherSqliteDemoConnectRequest();
			break;
		case CORRECTIONSUBMIT:
			request = new LoadCorrectionSubmitSqliteDemoRequest();
			break;
		case SYSDATE:
			request = new SystemDateSqliteDemoConnectRequest();
			break;
		default:

		}
		return request;
	}

	/**
	 * 根据查询对象类型，获取相对应的枚举类型
	 * 
	 * @param serverSearch
	 * @return
	 */
	private static <T> ConnectRequestEnum getConnectRequestEnum(ServerSearch<T> serverSearch) {
		if (serverSearch instanceof LoadMonitorSearch) {
			return ConnectRequestEnum.LOADMONITOR;
		} else if (serverSearch instanceof UserValidateSearch) {
			return ConnectRequestEnum.USERVALIDATE;
		} else if (serverSearch instanceof LoadCorrectionSearch) {
			return ConnectRequestEnum.LOADCORRECTION;
		} else if (serverSearch instanceof LoadAnalyzeSearch) {
			return ConnectRequestEnum.LOADANALYZE;
		} else if (serverSearch instanceof WeatherSearch) {
			return ConnectRequestEnum.WEATHER;
		} else if (serverSearch instanceof CorrectionSubmitSearch) {
			return ConnectRequestEnum.CORRECTIONSUBMIT;
		} else if (serverSearch instanceof SystemDateSearch) {
			return ConnectRequestEnum.SYSDATE;
		}
		return null;
	}
}
