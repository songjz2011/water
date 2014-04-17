package com.tsingsoft.android.entity.db.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.tsingsoft.android.entity.LfCtrlNet;

/**
 * <pre>
 * 电网dao
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月17日
 */
public class LfCtrlNetDao {

	private static final String TABLE_NAME = "LF_CTRL_NET";

	public LfCtrlNetDao(Context context) {
	}

	/**
	 * 获取用户能够看到的电网集合
	 */
	public List<LfCtrlNet> findUserNet(String username) {
		return null;
	}

	/**
	 * 获取电网信息
	 */
	public LfCtrlNet findNetByNetId(String netID) {
		return null;
	}

	/**
	 * 通过用户名和单位返回偏差值。
	 * 
	 * @param username
	 * @param netId
	 * @return
	 */
	public String getLoadWarnOffSet(String username, String netId) {
		return null;
	}

	/**
	 * 更新电网的负荷监控偏差值
	 * 
	 * @param username
	 * @param offset
	 */
	public void updateLoadMonitorOffset(String username, String netId, String offset) {
	}

	/**
	 * 获取电网的偏差值设置信息
	 * 
	 * @param netId
	 * @return
	 */
	public String findLoadMonitorOffsetByNetId(String netId) {
		return null;
	}

	/**
	 * 清除电网数据
	 */
	public void clearNet() {
	}

	/**
	 * 新增电网数据
	 * 
	 * @param netList
	 */
	public void insertNetList(List<LfCtrlNet> netList, String username) {
	}

	/**
	 * 构造新插入电网集合，目前主要是为了设置已经存储的负荷监控偏差
	 * 
	 * @param netList
	 *            ：从远程获取新的电网集合
	 * @param oldNetList
	 *            ：本地存储的旧的电网集合
	 * @return
	 */
	private List<LfCtrlNet> buildNewInsertNetList(List<LfCtrlNet> netList,
			List<LfCtrlNet> oldNetList) {
		if (oldNetList == null || oldNetList.isEmpty()) {
			return netList;
		}
		List<LfCtrlNet> result = new ArrayList<LfCtrlNet>();
		for (LfCtrlNet net : netList) {
			LfCtrlNet oldNet = null;
			for (LfCtrlNet oldLfCtrlNet : oldNetList) {
				if (oldLfCtrlNet.getNetId().equals(net.getNetId())) {
					oldNet = oldLfCtrlNet;
					break;
				}
			}
			if (oldNet != null) {
				net.setLoadMonitorOffset(oldNet.getLoadMonitorOffset());
			}
			result.add(net);
		}
		return result;
	}

	/**
	 * 清除用户的电网信息
	 * 
	 * @param username
	 */
	private void clearUserNet(String username) {
	}
}
