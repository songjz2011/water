/*
 * LoadAnalyzeSearch.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.tsingsoft.android.entity.LoadAnalyze;

/**
 * <pre>
 * 负荷分析查询对象
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月18日
 */
public class LoadAnalyzeSearch extends AbstractServerSearch<LoadAnalyze> {

	public ServerSearchCondition buildSearchCondition() {
		ServerSearchCondition serverSearchCondition = new ServerSearchCondition();
		// StringBuilder condition = new StringBuilder();
		// condition.append("netId=").append(trim(getNetId()));
		// condition.append("&caliberId=").append(trim(getCaliberId()));
		// condition.append("&loadYmds=").append(buildYmd(getYmdList()));
		// serverSearchCondition.setSearchCondition(condition.toString());
		List<NameValuePair> pairList = new ArrayList<NameValuePair>();
		pairList.add(new BasicNameValuePair("netId", trim(getNetId())));
		pairList.add(new BasicNameValuePair("caliberId", trim(getCaliberId())));
		pairList.add(new BasicNameValuePair("loadYmds", buildYmd(getYmdList())));
		serverSearchCondition.setPairList(pairList);
		return serverSearchCondition;
	}

	/**
	 * 构造日期值
	 * 
	 * @param ymdList
	 * @return
	 */
	private String buildYmd(List<String> ymdList) {
		if (ymdList == null || ymdList.isEmpty()) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		for (String ymd : ymdList) {
			result.append(",").append(ymd);
		}
		return result.substring(1);
	}

}
