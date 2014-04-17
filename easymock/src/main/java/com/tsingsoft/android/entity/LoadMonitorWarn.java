package com.tsingsoft.android.entity;

/**
 * <pre>
 * 负荷监控警报信息
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月20日
 */
public class LoadMonitorWarn {
	
	/**
	 * 主键ID
	 */
	private String id;

	/**
	 * 电网ID
	 */
	private String netId;

	/**
	 * 警报信息
	 */
	private String message;
	
	/**
	 * 是否已读 0=未读 1=已读
	 */
	private String isRead;
	
	/**
	 * 预警时间 96点时刻
	 */
	private String warnTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public String getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(String warnTime) {
		this.warnTime = warnTime;
	}

}
