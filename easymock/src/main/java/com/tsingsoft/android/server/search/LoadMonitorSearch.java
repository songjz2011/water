/*
 * LoadMonitorSearch.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.tsingsoft.android.entity.LoadMonitor;

/**
 * <pre>
 * 负荷监控数据的查询对象
 * </pre>
 * 
 * @author songjz
 * @time 2013-12-9
 */
public class LoadMonitorSearch extends AbstractServerSearch<LoadMonitor> {

	/** 获取数据延迟时间，单位为分钟，默认为0分钟（即不延迟） */
	private int delayTime;

	/** 设置的负荷偏差，多个用"，"分隔 */
	private String loadOffset;
	
	/** 当前往前和往后推的时间偏差，单位为小时 */
	private String timeOffset = "2";

	public ServerSearchCondition buildSearchCondition() {
		ServerSearchCondition serverSearchCondition = new ServerSearchCondition();
		// StringBuilder condition = new StringBuilder();
		// condition.append("netId=").append(trim(getNetId()));
		// condition.append("&caliberId=").append(trim(getCaliberId()));
		// condition.append("&delayTime=").append(trim(getDelayTime()));
		// condition.append("&loadOffset=").append(trim(getLoadOffset()));
		// condition.append("&timeOffset=").append(trim(getTimeOffset()));
		// serverSearchCondition.setSearchCondition(condition.toString());
		List<NameValuePair> pairList = new ArrayList<NameValuePair>();
		pairList.add(new BasicNameValuePair("netId", trim(getNetId())));
		pairList.add(new BasicNameValuePair("caliberId", trim(getCaliberId())));
		pairList.add(new BasicNameValuePair("delayTime", trim(getDelayTime())));
		pairList.add(new BasicNameValuePair("loadOffset", trim(getLoadOffset())));
		pairList.add(new BasicNameValuePair("timeOffset", trim(getTimeOffset())));

		serverSearchCondition.setPairList(pairList);
		return serverSearchCondition;
	}

	public int getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(int delayTime) {
		this.delayTime = delayTime;
	}

	public String getLoadOffset() {
		return loadOffset;
	}

	public void setLoadOffset(String loadOffset) {
		this.loadOffset = loadOffset;
	}

	public String getTimeOffset() {
		return timeOffset;
	}

	public void setTimeOffset(String timeOffset) {
		this.timeOffset = timeOffset;
	}

}
