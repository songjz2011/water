/*
 * WeatherSqliteDemoConnectRequest.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.connect.sqlite.demo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tsingsoft.android.entity.Weather;
import com.tsingsoft.android.entity.WeatherDetail;
import com.tsingsoft.android.server.connect.http.HttpConnectRequest;
import com.tsingsoft.android.server.connect.sqlite.demo.helper.WeatherSqliteDemoHelper;
import com.tsingsoft.android.server.exception.SearchException;
import com.tsingsoft.android.server.search.ServerSearch;
import com.tsingsoft.android.server.search.ServerSearchCondition;

/**
 * <pre>
 * 天气数据 - demo使用Sqlite - 连接服务器端的请求
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月26日
 */
public class WeatherSqliteDemoConnectRequest extends HttpConnectRequest {

	@SuppressWarnings("unchecked")
	public <T> T search(ServerSearch<T> search, Context context) throws SearchException {
		ServerSearchCondition condition = search.buildSearchCondition();
		WeatherSqliteDemoHelper helper = new WeatherSqliteDemoHelper(condition, context);
		String result = helper.getResult();
		return (T) buildClientEntity(result);
	}

	private Weather buildClientEntity(Object result) {
		JSONObject json = assertReturnData(result);
		Weather weather = new Weather();
		weather.setCurDetail(buildCurWeatherDetail(json));
		// 设置历史
		weather.setHisDetail(buildOtherDayWeatherDetail(json.getJSONArray("hisWeather")));
		// 设置未来
		weather.setFutureDetail(buildOtherDayWeatherDetail(json.getJSONArray("futuerWeather")));
		return weather;
	}

	/**
	 * 构建其他天的天气数据
	 * 
	 * @param array
	 * @return
	 */
	private List<WeatherDetail> buildOtherDayWeatherDetail(JSONArray array) {
		List<WeatherDetail> list = new ArrayList<WeatherDetail>();
		for (int i = 0; i < array.size(); i++) {
			JSONObject object = (JSONObject) array.get(i);
			WeatherDetail detail = new WeatherDetail();
			detail.setYmd(object.getString("ymd"));
			detail.setWeekDay(object.getString("weekDay"));
			// 为最低最高的显示值：例如：7-19℃
			detail.setTemperature(object.getString("tempreture"));
			detail.setWeatherType(object.getString("weatherType"));
			list.add(detail);
		}
		return list;
	}

	/**
	 * 构建当前日期的天气数据
	 * 
	 * @param json
	 * @return
	 */
	private WeatherDetail buildCurWeatherDetail(JSONObject json) {
		JSONObject object = json.getJSONObject("curWeather");
		WeatherDetail detail = new WeatherDetail();
		detail.setYmd(object.getString("ymd"));
		detail.setWeekDay(object.getString("weekDay"));
		// 为平均温度
		detail.setTemperature(object.getString("tempreture"));
		detail.setWeatherType(object.getString("weatherType"));
		detail.setWindDirection(object.getString("windDirection"));
		detail.setWindPower(object.getString("windPower"));
		detail.setHumidity(object.getString("humidity"));
		return detail;
	}

}
