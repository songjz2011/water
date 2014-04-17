package com.tsingsoft.android.util;


/**
 * <pre>
 * 时刻点对象
 * </pre>
 * 
 * @author songjz
 * @time 2013-12-11
 */
public class PointTime {

	/** 时刻点所在的日期 */
	private String ymd;

	/** 时刻点，例如：T0015 */
	private String point;

	public String getYmd() {
		return ymd;
	}

	public void setYmd(String ymd) {
		this.ymd = ymd;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

}
