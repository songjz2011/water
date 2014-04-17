package com.tsingsoft.android.entity;

/**
 * 预警信息设置
 * @author LJ
 *
 */
public class AlarmSetting {
	
	/**
	 * 自动关闭时间，如果为0，则表示不自己关闭
	 * 单位为毫秒
	 */
	private int warnCloseTime;

	public int getWarnCloseTime() {
		return warnCloseTime;
	}

	public void setWarnCloseTime(int warnCloseTime) {
		this.warnCloseTime = warnCloseTime;
	}

}
