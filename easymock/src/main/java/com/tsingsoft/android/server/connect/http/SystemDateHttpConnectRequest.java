package com.tsingsoft.android.server.connect.http;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;
import com.tsingsoft.android.entity.SystemDate;
import com.tsingsoft.android.server.exception.SearchException;
import com.tsingsoft.android.server.search.ServerSearch;
import com.tsingsoft.android.server.search.ServerSearchCondition;

/**
 * 获取服务器系统时间
 * @author F.Liu
 *
 */
public class SystemDateHttpConnectRequest extends HttpConnectRequest{

	public <T> T search(ServerSearch<T> search, Context context)
			throws SearchException {
		String urlAction = getUrlAction(context);
		ServerSearchCondition condition = search.buildSearchCondition();
		List<NameValuePair> pairList = condition.getPairList();
		pairList.add(new BasicNameValuePair("command", "SystemDateTime"));
		Object result = postWithHttpClient(urlAction, pairList, context);
		return (T) buildClientEntity(result,context);
	}
	
	private SystemDate buildClientEntity(Object obj,Context context){
		JSONObject json = assertReturnData(obj);
		SystemDate sysDate = new SystemDate();
		// 参考负荷
		String dateTime = getStringJSONObject(json, "dateTime");
		sysDate.setSysDateStr(dateTime);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
		Date date =null ;
		try {
			date = format.parse(dateTime);
		} catch (Exception e) {
		}
		sysDate.setSysDate(date);
		sysDate.setSysDateYMD(dateTime.substring(0,8));
		sysDate.setSysTime(dateTime.substring(9,14));
		return sysDate;
		 
	}

}
