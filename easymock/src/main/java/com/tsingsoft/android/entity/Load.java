package com.tsingsoft.android.entity;

import java.util.TreeMap;

/**
 * <pre>
 * 负荷对象
 * </pre>
 * 
 * @author songjz
 * @time 2013-12-9
 */
public class Load {

	/** 负荷数据的日期(格式yyyyMMdd) */
	protected String loadYmd;

	/** 历史负荷，key：时刻点（格式为10:30），value：时刻点的值 */
	protected TreeMap<String, Double> hisLoadMap;

	public String getLoadYmd() {
		return loadYmd;
	}

	public void setLoadYmd(String loadYmd) {
		this.loadYmd = loadYmd;
	}

	public TreeMap<String, Double> getHisLoadMap() {
		return hisLoadMap;
	}

	public void setHisLoadMap(TreeMap<String, Double> hisLoadMap) {
		this.hisLoadMap = hisLoadMap;
	}
}
