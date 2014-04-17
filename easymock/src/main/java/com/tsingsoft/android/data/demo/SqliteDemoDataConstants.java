/*
 * SqliteDemoDataConstants.java
 * Copyright: Copyright TsingSoft (c) 2014
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.data.demo;

import java.util.Calendar;
import java.util.Date;

/**
 * <pre>
 * sqlite的Demo数据的常量
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月25日
 */
public class SqliteDemoDataConstants {

	/**
	 * 默认当天采用20140130号的数据
	 */
	private static Date defaultCurDate = null;

	static {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 30);
		cal.set(Calendar.HOUR_OF_DAY, 10);
		cal.set(Calendar.MINUTE, 10);
		cal.set(Calendar.SECOND, 10);

		defaultCurDate = cal.getTime();
	}

	public static Date getDefaultCurDate() {
		return defaultCurDate;
	}

}
