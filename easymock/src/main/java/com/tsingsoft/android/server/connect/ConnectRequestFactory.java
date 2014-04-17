package com.tsingsoft.android.server.connect;

import com.tsingsoft.android.server.ServerSearchConstant;
import com.tsingsoft.android.server.connect.http.CorrectionSubmitRequest;
import com.tsingsoft.android.server.connect.http.LoadAnalyzeHttpConnectRequest;
import com.tsingsoft.android.server.connect.http.LoadCorrectionRequest;
import com.tsingsoft.android.server.connect.http.LoadMonitorHttpConnectRequest;
import com.tsingsoft.android.server.connect.http.SystemDateHttpConnectRequest;
import com.tsingsoft.android.server.connect.http.UserValidateHttpConnectRequest;
import com.tsingsoft.android.server.connect.http.WeatherHttpConnectRequest;
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
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2013-12-9
 */
public class ConnectRequestFactory {

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
			request = new LoadMonitorHttpConnectRequest();
			break;
		case USERVALIDATE:
			request = new UserValidateHttpConnectRequest();
			break;
		case LOADANALYZE:
			request = new LoadAnalyzeHttpConnectRequest();
			break;
		case LOADCORRECTION:
			request = new LoadCorrectionRequest();
			break;
		case WEATHER:
			request = new WeatherHttpConnectRequest();
			break;
		case CORRECTIONSUBMIT:
			request = new CorrectionSubmitRequest();
			break;
		case SYSDATE:
			request =new SystemDateHttpConnectRequest();
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
		} else if (serverSearch instanceof CorrectionSubmitSearch){
			return ConnectRequestEnum.CORRECTIONSUBMIT;
		} else if (serverSearch instanceof SystemDateSearch){
			return ConnectRequestEnum.SYSDATE;
		}
		return null;
	}

}
