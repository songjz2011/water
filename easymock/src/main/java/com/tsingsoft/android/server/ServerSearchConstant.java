package com.tsingsoft.android.server;

import java.util.HashMap;
import java.util.Map;

import com.tsingsoft.android.util.StringUtil;

/**
 * <pre>
 * 数据常量
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月10日
 */
public class ServerSearchConstant {
	/** 国际化 */
	private static Map<String, String> messageMap = new HashMap<String, String>();
	public final static String defaultCaliberID = "00";
	public final static String defaultNetID = "00";
	static {
		messageMap.put("connect.error", "获取数据失败，请检查网络连接");
		messageMap.put("server.object.error", "获取服务连接对象失败");
		messageMap.put("obtain.data.error", "获取数据失败");
		messageMap.put("user.error", "用户信息有误");
	}

	public static String getMessage(String code) {
		return messageMap.get(code);
	}

	public static String getMessage(String code, String defaultMessage) {
		String message = messageMap.get(code);
		if (StringUtil.isEmpty(message)) {
			return defaultMessage;
		}
		return message;
	}

	public final static String SERVERERRORMESSAGEKEY = "errorMessage";

}
