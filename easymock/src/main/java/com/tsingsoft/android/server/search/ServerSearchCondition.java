/*
 * ServerSearchCondition.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.search;

import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;

/**
 * <pre>
 * 请求服务器端的查询条件对象
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月13日
 */
public class ServerSearchCondition {

	/** 辅助信息 */
	private Map<String, String> assistInfo;

	/**
	 * 查询条件，构建格式如：netId=00&caliberId=00&command=LoadMonitor
	 */
	private String searchCondition;

	/**
	 * <pre>
	 * 该参数和searchCondition，功能是一样的，两者只需要设置一个即可
	 * 构建格式如：
	 * pairList.add(new new BasicNameValuePair("netId", "00"));
	 * pairList.add(new new BasicNameValuePair("caliberId", "00"));
	 * pairList.add(new new BasicNameValuePair("command", "LoadMonitor"));
	 * 
	 * 若设置：searchCondition，在进行查询远程数据时，请采用HttpConnectRequest.post方法
	 * 设置pairList，在进行查询远程数据时，请采用HttpConnectRequest.postWithHttpClient方法
	 * </pre>
	 */
	private List<NameValuePair> pairList;

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public Map<String, String> getAssistInfo() {
		return assistInfo;
	}

	public void setAssistInfo(Map<String, String> assistInfo) {
		this.assistInfo = assistInfo;
	}

	public List<NameValuePair> getPairList() {
		return pairList;
	}

	public void setPairList(List<NameValuePair> pairList) {
		this.pairList = pairList;
	}

}
