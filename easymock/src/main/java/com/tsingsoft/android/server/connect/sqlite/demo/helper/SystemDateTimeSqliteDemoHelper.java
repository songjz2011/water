package com.tsingsoft.android.server.connect.sqlite.demo.helper;

import java.util.Date;
import java.util.TreeMap;

import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import com.tsingsoft.android.data.demo.SqliteDemoDataConstants;
import com.tsingsoft.android.server.search.ServerSearchCondition;
import com.tsingsoft.android.util.DateUtil;

/**
 * 获取服务器时间
 * 
 * @author LiuFeng
 * @time 2013-12-30
 */
public class SystemDateTimeSqliteDemoHelper extends BaseSliteDemoHelper {

	public SystemDateTimeSqliteDemoHelper(ServerSearchCondition condition, Context context) {
		this.context = context;
	}

	public String getResult() {
		TreeMap<String, Object> result = new TreeMap<String, Object>();
		Date curDate = SqliteDemoDataConstants.getDefaultCurDate();
		String datetime = DateUtil.formatDate(curDate, "yyyyMMdd HH:mm:ss");
		result.put("dateTime", datetime);
		String jsonStr = JSONArray.toJSONString(result);
		return jsonStr;
	}

}
