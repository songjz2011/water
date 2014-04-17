/*
 * LfHis96LcDao.java
 * Copyright: Copyright TsingSoft (c) 2014
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.entity.db.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import android.content.Context;

import com.tsingsoft.android.common.SysConstant;
import com.tsingsoft.android.entity.LfHis96Lc;
import com.tsingsoft.android.util.QueryUtil;

/**
 * <pre>
 * 96点负荷dao
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月25日
 */
public class LfHis96LcDao {

	private static final String TABLE_NAME = "LF_HIS_96LC";

	public LfHis96LcDao(Context context) {
	}

	/**
	 * 获取96点负荷，返回值，key：日期（格式为yyyyMMdd）
	 * 
	 * @param netId
	 * @param caliberId
	 * @param ymds
	 *            ：查询的日期（格式yyyyMMdd）
	 * @return
	 */
	public TreeMap<String, LfHis96Lc> getDatas(String netId, String caliberId, List<String> ymds) {
		TreeMap<String, LfHis96Lc> map = new TreeMap<String, LfHis96Lc>();
		StringBuilder sql = new StringBuilder();
		String[] columns = SysConstant.DAY_LOAD_CURVE_96COLUMN;
		sql.append("SELECT NETID,CALIBERID,YMD");
		for (String col : columns) {
			sql.append(",").append(col);
		}
		sql.append(" FROM ").append(TABLE_NAME).append(" ");
		sql.append("WHERE NETID='").append(netId).append("' ");
		sql.append("AND CALIBERID='").append(caliberId).append("' ");
		sql.append("AND ").append(QueryUtil.buildInCondition(ymds, "YMD"));

		return map;
	}

	public LfHis96Lc getDataByDay(String netID, String caliberID, String ymd) {
		List<String> list=new ArrayList<String>();
		list.add(ymd);
		StringBuilder sql = new StringBuilder();
		String[] columns = SysConstant.DAY_LOAD_CURVE_96COLUMN;
		sql.append("SELECT NETID,CALIBERID,YMD");
		for (String col : columns) {
			sql.append(",").append(col);
		}
		sql.append(" FROM ").append(TABLE_NAME).append(" ");
		sql.append("WHERE NETID='").append(netID).append("' ");
		sql.append("AND CALIBERID='").append(caliberID).append("' ");
		sql.append("AND ").append(QueryUtil.buildInCondition(list, "YMD"));

		return null;

	}
}
