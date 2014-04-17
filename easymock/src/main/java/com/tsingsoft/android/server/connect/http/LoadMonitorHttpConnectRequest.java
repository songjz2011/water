/*
 * LoadMonitorHttpConnectRequest.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.connect.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tsingsoft.android.entity.LoadMonitor;
import com.tsingsoft.android.server.exception.SearchException;
import com.tsingsoft.android.server.search.ServerSearch;
import com.tsingsoft.android.server.search.ServerSearchCondition;

/**
 * <pre>
 * 负荷监控 - http协议 - 连接服务器端的请求
 * </pre>
 * 
 * @author songjz
 * @time 2013-12-9
 */
public class LoadMonitorHttpConnectRequest extends HttpConnectRequest {

	@SuppressWarnings("unchecked")
	public <T> T search(ServerSearch<T> search, Context context)
			throws SearchException {
		String urlAction = getUrlAction(context);
		ServerSearchCondition condition = search.buildSearchCondition();
		List<NameValuePair> pairList = condition.getPairList();
		pairList.add(new BasicNameValuePair("command", "LoadMonitor"));
		Object result = postWithHttpClient(urlAction, pairList, context);
		// String param = condition.getSearchCondition() +
		// "&command=LoadMonitor";
		// Object result = post(urlAction, param, context);
		return (T) buildClientEntity(result);
	}

	private LoadMonitor buildClientEntity(Object obj) {
		LoadMonitor rtLoad = new LoadMonitor();
		List<LoadMonitor> list = new ArrayList<LoadMonitor>();
		JSONArray valueArray = assertReturnArray(obj);
		for (Object object : valueArray) {
			JSONObject json = assertReturnData(object);
			LoadMonitor load = new LoadMonitor();
			// 历史负荷
			load.setHisLoadList(getDoubleList(json, "hisLoad"));
			// 预测负荷
			load.setForecastLoadList(getDoubleList(json, "forecastLoad"));
			// 时刻点
			load.setPointTimeList(getStringList(json, "pointTimeList"));
			// 时刻点准确率
			load.setPointAccuracyRate(getStringJSONObject(json,
					"pointAccuracyRate"));
			load.setDayAccuracyRate(getStringJSONObject(json,
					"dayAccuracyRate"));
			
			// 偏差量
			load.setLoadOffset(getStringJSONObject(json,
					"loadAccuracyOffset"));
			
			// 服务器系统当前时间
			load.setCurHourMinute(getStringJSONObject(json, "curHourMinute"));
			load.setCurYmd(getStringJSONObject(json, "curYmd"));
			load.setNetId(getStringJSONObject(json, "rtnNetId"));
			// 负荷时刻点数据
			load.setPoint(getStringJSONObject(json, "point"));
			load.setPointForecastLoad(getStringJSONObject(json,
					"pointForecastLoad"));
			load.setPointHisLoad(getStringJSONObject(json, "pointHisLoad"));
			// 时刻点的 实际负荷和预测负荷之间的偏差 超过了设置的偏差值 的结果（绝对值）
			load.setPointLoadOverOffset(getStringJSONObject(json,
					"pointLoadOverOffset"));
			// 监控图形的图例 显示的日期
			load.setLegendYmd(getStringJSONObject(json, "legendYmd"));
			list.add(load);
		}
		rtLoad.setLoadMonitors(list);
		return rtLoad;
	}

}
