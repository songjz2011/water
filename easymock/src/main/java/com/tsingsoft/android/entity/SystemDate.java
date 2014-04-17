package com.tsingsoft.android.entity;

import java.util.Date;

/**
 * 服务器时间
 * @author F.Liu
 *
 */
public class SystemDate {
	
	/**
	 * 服务器日期
	 */
	private Date sysDate;
	
	/**
	 * 服务器日期 格式-20131230 10:17:00
	 */
	private String sysDateStr;
	
	/**
	 * 服务器日期 格式-20131230
	 */
	private String sysDateYMD;
	
	/**
	 * 服务器时间 格式  时：分 （09:30）
	 */
	private String sysTime;

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

	public String getSysDateStr() {
		return sysDateStr;
	}

	public void setSysDateStr(String sysDateStr) {
		this.sysDateStr = sysDateStr;
	}

	public String getSysDateYMD() {
		return sysDateYMD;
	}

	public void setSysDateYMD(String sysDateYMD) {
		this.sysDateYMD = sysDateYMD;
	}

	public String getSysTime() {
		return sysTime;
	}

	public void setSysTime(String sysTime) {
		this.sysTime = sysTime;
	}
}
