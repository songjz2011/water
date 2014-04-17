/*
 * LoadMonitorWarnDao.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.entity.db.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.content.Context;

import com.tsingsoft.android.entity.LoadMonitorWarn;
import com.tsingsoft.android.util.DateUtil;

/**
 * <pre>
 * 负荷监控警报信息dao
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月20日
 */
public class LoadMonitorWarnDao {

	private static final String TABLE_NAME = "LOAD_MONITOR_WARN";

	private Context context = null;

	public LoadMonitorWarnDao(Context context) {
	}

	/**
	 * 获取电网的警报信息
	 * 
	 * @param netId
	 * @return
	 */
	public List<LoadMonitorWarn> findByNetId(String netId) {
		return null;
	}
	
	/**
	 * 获取所有电网的警报信息
	 * 
	 * @param netId
	 * @return
	 */
	public List<LoadMonitorWarn> findByAllNet() {
		return null;
	}

	/**
	 * 判断当前时刻（包括延时后）是否存在未读的预警信息。
	 * 
	 * @param netId
	 *            单位
	 * @param currentTime
	 *            当前时刻
	 * @return
	 */
	public boolean currentTimeHasWarnRecord(String currentTime, int delayTime) {
		boolean rtn = false;
		return rtn;
	}
	
	/**
	 * 判断当前时刻（包括延时后）是否存在预警信息。
	 * 
	 * @param netId
	 *            单位
	 * @param currentTime
	 *            当前时刻
	 * @return
	 */
	public boolean currentTimeHasWarnRecordBySystem(String currentTime, int delayTime) {
		boolean rtn = false;
		return rtn;
	}

	/**
	 * 修改预警信息已读状态
	 * @param list
	 */
	public void updateWarnReadStat(List<LoadMonitorWarn> list){
	}
	
	
	private String buildCurrentTime(String currentTime, int delayTime) {
		String time = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
			Date date = format.parse("20101010 " + currentTime + ":00");
			Date delyDate = DateUtil.addMinute(date, -delayTime);
			String newDate = format.format(delyDate);
			time = newDate.substring(9, 14);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return time;
	}

	/**
	 * 保存警报信息
	 * 
	 * @param netId
	 * @param message
	 */
	public void save(String netId, String message, String currentTime) {
	}

	private String changeCurrentTime(String currentTime) {
		String time = null;
		if (currentTime != null && currentTime.length() > 0) {
			String[] arr = currentTime.split(":");
			if (arr.length > 0) {
				String hour = arr[0];
				int min = Integer.parseInt(arr[1]);
				if (0 <= min && min < 15) {
					time = hour + ":" + 00;
				} else if (15 <= min && min < 30) {
					time = hour + ":" + 15;
				} else if (30 <= min && min < 45) {
					time = hour + ":" + 30;
				} else {
					time = hour + ":" + 45;
				}
			}
		}
		return time;
	}

	/**
	 * 判断保存的警报信息是否存在
	 * 
	 * @return
	 */
	private boolean isExist(String netId, String message, String currentTime) {
		return false;
	}

	/**
	 * 清除警报信息
	 */
	public void clearWarn() {
	}
}
