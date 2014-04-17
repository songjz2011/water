/*
 * WeatherSearch.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.tsingsoft.android.entity.Weather;

/**
 * <pre>
 * 天气数据查询
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月19日
 */
public class WeatherSearch extends AbstractServerSearch<Weather> {

	public ServerSearchCondition buildSearchCondition() {
		ServerSearchCondition serverSearchCondition = new ServerSearchCondition();
		List<NameValuePair> pairList = new ArrayList<NameValuePair>();
		pairList.add(new BasicNameValuePair("netId", trim(getNetId())));
		serverSearchCondition.setPairList(pairList);
		return serverSearchCondition;
	}

}
