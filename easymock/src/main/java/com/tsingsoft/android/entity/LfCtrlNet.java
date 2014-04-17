package com.tsingsoft.android.entity;


/**
 * <pre>
 * 电网信息
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月17日
 */
public class LfCtrlNet {

	/** 电网id */
	private String netId;

	/** 电网名称 */
	private String netName;

	/** 上级电网id */
	private String upNetId;

	/** 电网级别 */
	private int netLevel;

	/** 负荷监控偏差 */
	private String loadMonitorOffset;

	/** 电网所属用户的用户名，例如：admin */
	private String userName;
	
	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public String getNetName() {
		return netName;
	}

	public void setNetName(String netName) {
		this.netName = netName;
	}

	public String getUpNetId() {
		return upNetId;
	}

	public void setUpNetId(String upNetId) {
		this.upNetId = upNetId;
	}

	public int getNetLevel() {
		return netLevel;
	}

	public void setNetLevel(int netLevel) {
		this.netLevel = netLevel;
	}

	public String getLoadMonitorOffset() {
		return loadMonitorOffset;
	}

	public void setLoadMonitorOffset(String loadMonitorOffset) {
		this.loadMonitorOffset = loadMonitorOffset;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
