/*
 * StHisFactorDao.java
 * Copyright: Copyright TsingSoft (c) 2014
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.entity.db.dao;

import java.util.List;
import java.util.TreeMap;

import android.content.Context;

import com.tsingsoft.android.util.QueryUtil;

/**
 * <pre>
 * 历史相关信息数据Dao
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月26日
 */
public class StHisFactorDao {
	private static final String TABLE_NAME = "ST_HIS_FACTOR";

	public StHisFactorDao(Context context) {
	}

	/**
	 * 获取 电网的时间内 历史相关信息数据
	 * 
	 * @param ymds
	 * @param netId
	 * @return
	 */
	public TreeMap<String, TreeMap<String, Double>> getFactorsValue(List<String> ymds, String netId) {
		TreeMap<String, TreeMap<String, Double>> factors = new TreeMap<String, TreeMap<String, Double>>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT FACTORID,YMD,BEFOREVALUE FROM ").append(TABLE_NAME).append(" ");
		sql.append("WHERE NETID='").append(netId).append("' ");
		sql.append("AND ").append(QueryUtil.buildInCondition(ymds, "YMD"));
		return factors;
	}
}
