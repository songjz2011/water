/*
 * AbstractServerSearch.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.search;

import java.util.List;

import com.tsingsoft.android.util.StringUtil;

/**
 * <pre>
 * 请求服务器端的查询接口 抽象实现
 * </pre>
 * 
 * @author songjz
 * @param <T>
 * @time 2013-12-9
 */
public abstract class AbstractServerSearch<T> implements ServerSearch<T> {

	/** 电网ID */
	protected String netId;

	/** 口径ID */
	protected String caliberId;

	/** 日期集合（格式:yyyyMMdd） */
	protected List<String> ymdList;

	/**
	 * 去除对象前后空格
	 * 
	 * @param value
	 * @param defalutValue
	 *            ：若对象为空，返回的默认值
	 * @return
	 */
	protected String trim(Object value, String defalutValue) {
		return StringUtil.trim(value, defalutValue);
	}

	/**
	 * 去除对象前后空格
	 * 
	 * @param value
	 * @return
	 */
	protected String trim(Object value) {
		return StringUtil.trim(value);
	}

	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public String getCaliberId() {
		return caliberId;
	}

	public void setCaliberId(String caliberId) {
		this.caliberId = caliberId;
	}

	public List<String> getYmdList() {
		return ymdList;
	}

	public void setYmdList(List<String> ymdList) {
		this.ymdList = ymdList;
	}

}
