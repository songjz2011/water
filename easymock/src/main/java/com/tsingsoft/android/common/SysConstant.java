package com.tsingsoft.android.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * <pre>
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月25日
 */
public class SysConstant {

	/** 错误信息 */
	public static final String ERROR_MESSAGE = "errorMessage";

	/** 96点负荷日志的列名。 */
	public static final String[] DAY_LOAD_CURVE_96COLUMN = new String[96];

	/** 系统操作的负荷日志是否从0点开始。 */
	public static final boolean DAY_LOAD_CURVE_START_WITH_ZERO = false;

	static {
		DateFormat sdf = new SimpleDateFormat("HHmm");

		Calendar calendar = Calendar.getInstance();
		calendar.set(2000, 0, 1, 0, 0, 0);
		if (!DAY_LOAD_CURVE_START_WITH_ZERO) {
			calendar.add(Calendar.MINUTE, 15);
		}
		for (int i = 0; i < 96; i++) {
			String time = sdf.format(calendar.getTime());
			if (!DAY_LOAD_CURVE_START_WITH_ZERO && "0000".equals(time)) {
				time = "2400";
			}
			DAY_LOAD_CURVE_96COLUMN[i] = "T" + time;
			calendar.add(Calendar.MINUTE, 15);
		}
	}
}
