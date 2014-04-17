/*
 * BaseSliteDemoHelper.java
 * Copyright: Copyright TsingSoft (c) 2014
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.connect.sqlite.demo.helper;

import java.text.NumberFormat;
import java.util.List;

import org.apache.http.NameValuePair;

import android.content.Context;

import com.tsingsoft.android.server.search.ServerSearchCondition;
import com.tsingsoft.android.util.NumberUtil;
import com.tsingsoft.android.util.PointLoadHandleUtil;

/**
 * <pre>
 * demo使用Sqlite - 处理数据逻辑 - 基础对象
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月26日
 */
public class BaseSliteDemoHelper {

	protected Context context;

	/** 电网ID */
	protected String netId;

	/** 口径ID */
	protected String caliberId;

	/**
	 * 保留2位小数的格式
	 */
	protected NumberFormat format = NumberUtil.getNumberFormat();

	/**
	 * <pre>
	 * 从ServerSearchCondition.getPairList中获取参数值
	 * 若不存在，则返回""
	 * </pre>
	 * 
	 * @param name
	 *            : 参数名称
	 * @param condition
	 * @return
	 */
	protected String getParameterValue(String name, ServerSearchCondition condition) {
		List<NameValuePair> pairList = condition.getPairList();
		for (NameValuePair pair : pairList) {
			if (name.equals(pair.getName())) {
				return pair.getValue();
			}
		}
		return "";
	}

	/**
	 * 格式化数据（保留两位小数）
	 */
	protected String numberFormatValue(Object value) {
		return PointLoadHandleUtil.numberFormatValue(value, format).toString();
	}
}
