/*
 * SystemDateSqliteDemoConnectRequest.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.connect.sqlite.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;
import com.tsingsoft.android.entity.SystemDate;
import com.tsingsoft.android.server.connect.http.HttpConnectRequest;
import com.tsingsoft.android.server.connect.sqlite.demo.helper.SystemDateTimeSqliteDemoHelper;
import com.tsingsoft.android.server.exception.SearchException;
import com.tsingsoft.android.server.search.ServerSearch;
import com.tsingsoft.android.server.search.ServerSearchCondition;

/**
 * <pre>
 * 获取服务器系统时间
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月26日
 */
public class SystemDateSqliteDemoConnectRequest extends HttpConnectRequest {

	@SuppressWarnings("unchecked")
	public <T> T search(ServerSearch<T> search, Context context) throws SearchException {
		ServerSearchCondition condition = search.buildSearchCondition();
		SystemDateTimeSqliteDemoHelper helper = new SystemDateTimeSqliteDemoHelper(condition,
				context);
		Object result = helper.getResult();
		return (T) buildClientEntity(result, context);
	}

	private SystemDate buildClientEntity(Object obj, Context context) {
		JSONObject json = assertReturnData(obj);
		SystemDate sysDate = new SystemDate();
		// 参考负荷
		String dateTime = getStringJSONObject(json, "dateTime");
		sysDate.setSysDateStr(dateTime);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
		Date date = null;
		try {
			date = format.parse(dateTime);
		} catch (Exception e) {
		}
		sysDate.setSysDate(date);
		sysDate.setSysDateYMD(dateTime.substring(0, 8));
		sysDate.setSysTime(dateTime.substring(9, 14));
		return sysDate;

	}

}
