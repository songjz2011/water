/*
 * StFc96LcSubmitDao.java
 * Copyright: Copyright TsingSoft (c) 2014
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.entity.db.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.tsingsoft.android.common.SysConstant;
import com.tsingsoft.android.entity.StFc96LcSubmit;
import com.tsingsoft.android.util.QueryUtil;


/**
 * <pre>
 * 96点上报预测负荷dao
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月26日
 */
public class StFc96LcSubmitDao {
	private static final String TABLE_NAME = "ST_FC_96LC_SUBMIT";

	public StFc96LcSubmitDao(Context context) {
	}

	public List<StFc96LcSubmit> find(String netId, String caliberId, List<String> ymds) {
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
		sql.append(" ORDER BY YMD ASC");

		List<StFc96LcSubmit> list = new ArrayList<StFc96LcSubmit>();
		return list;
	}

	public List<StFc96LcSubmit> getFcSubmitLoadCurve(String netID,
			String caliberID, String ymd) {
		List<String> list = new ArrayList<String>();
		list.add(ymd);
		List<StFc96LcSubmit> result = find(netID, caliberID, list);
		return result;
	}
	public void updateFcSubmit(String netId, String caliberId, String ymd, List<String> loads) throws Exception{
		StringBuilder sql = new StringBuilder(); 
		String[] columns = SysConstant.DAY_LOAD_CURVE_96COLUMN;
		sql.append("UPDATE ST_FC_96LC_SUBMIT SET ");
		int length=loads.size();
		for(int i = 0 ; i< length;i++){
			String load = loads.get(i);
			String column = columns[i];
			sql.append(column+"="+load);
			if(i<length-1){
				sql.append(",");
			}
		}
		sql.append(" WHERE NETID='"+netId+"' AND CALIBERID='"+caliberId+"' AND YMD='"+ymd+"' ");
	}
}
