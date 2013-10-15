package com.web.things.db.driver.monitor.manager;

import com.web.things.db.driver.DBDriverOption;
import com.web.things.db.driver.util.DBDriverUtil;
import com.web.things.util.StringUtil;

/**
 * @author songjz
 * @time 2013年8月7日
 */
public class DBMonitorManager {

	protected static IDBMonitor dbMoniter;

	public synchronized static void init(DBDriverOption option) throws Exception {
		if (option == null || StringUtil.isEmpty(option.getMonitor())) {
			return;
		}
		String moniterName = option.getMonitor();
		dbMoniter = (IDBMonitor) DBDriverUtil.forName(moniterName).newInstance();
	}

	public static void moniter(Object obj) {
		if (dbMoniter == null) {
			return;
		}
		dbMoniter.moniter(obj);
	}

}
