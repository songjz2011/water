package com.web.things.db.driver.monitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.web.things.db.driver.monitor.manager.IDBMonitor;
import com.web.things.util.StringUtil;

/**
 * @author songjz
 * @time 2013年8月7日
 */
public class DBMonitorSql implements IDBMonitor {

	private static Map<String, String> filterTableNameMap = new HashMap<String, String>();

	static {
		List<String> tableName = new ArrayList<String>();
		tableName.add("LF_CTRL_NET");
		initFilterTableName(tableName);
	}

	public synchronized static void initFilterTableName(List<String> tableNameList) {
		filterTableNameMap.clear();
		if (tableNameList == null || tableNameList.isEmpty()) {
			return;
		}
		for (String tableName : tableNameList) {
			filterTableNameMap.put(tableName, tableName);
		}
	}

	public void moniter(Object obj) {
		if (obj == null || StringUtil.isEmpty(obj.toString())) {
			return;
		}
		String sql = obj.toString();
		filter(sql);
	}

	public boolean filter(String sql) {
		if (StringUtil.isEmpty(sql)) {
			return false;
		}
		if (isFilterOperate(sql)) {
			System.out.println("---------: " + sql);
			return true;
		}
		return false;
	}

	/**
	 * 是否是需要过滤的操作
	 * 
	 * @param sql
	 * @return
	 */
	private boolean isFilterOperate(String sql) {
		// 空白符进行分割
		String[] strs = sql.trim().split("\\s+", 4);
		if (strs.length < 2) {
			return false;
		}
		if (insertOperate(strs)) {
			return true;
		}
		if (updateOperate(strs)) {
			return true;
		}
		if (deleteOperate(strs)) {
			return true;
		}
		return false;
	}

	/**
	 * 插入操作
	 * 
	 * @param strs
	 * @return
	 */
	private boolean insertOperate(String[] strs) {
		if (!"insert".equalsIgnoreCase(strs[0].trim()) || strs.length < 3) {
			return false;
		}
		if (filterTableNameMap.get(strs[2].trim().toUpperCase()) == null) {
			return false;
		}
		return true;
	}

	/**
	 * 插入操作
	 * 
	 * @param strs
	 * @return
	 */
	private boolean updateOperate(String[] strs) {
		if (!"update".equalsIgnoreCase(strs[0].trim()) || strs.length < 3) {
			return false;
		}
		if (filterTableNameMap.get(strs[1].trim().toUpperCase()) == null) {
			return false;
		}
		return true;
	}

	/**
	 * 删除操作
	 * 
	 * @param strs
	 * @return
	 */
	private boolean deleteOperate(String[] strs) {
		if (!"delete".equalsIgnoreCase(strs[0].trim())) {
			return false;
		}
		String tableName = strs[1].trim().toUpperCase();
		if ("from".equalsIgnoreCase(tableName) && strs.length > 2) {
			tableName = strs[2].trim().toUpperCase();
		}
		if (filterTableNameMap.get(tableName) == null) {
			return false;
		}
		return true;
	}

}
