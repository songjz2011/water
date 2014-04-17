/*
 * StFactorMaplibDao.java
 * Copyright: Copyright TsingSoft (c) 2014
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.entity.db.dao;

import java.util.List;

import android.content.Context;

import com.tsingsoft.android.entity.StFactorMaplib;

/**
 * <pre>
 * 相关因素映射库信息Dao
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月26日
 */
public class StFactorMaplibDao {

	private static final String TABLE_NAME = "ST_FACTOR_MAPLIB";

	public StFactorMaplibDao(Context context) {
	}

	/**
	 * 查询所有的相关因素映射库信息
	 * 
	 * @return
	 */
	public List<StFactorMaplib> findAll() {
		return null;
	}

}
