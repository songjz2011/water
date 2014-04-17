package com.tsingsoft.android.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 数据列工具
 * 
 * @author F.Liu
 * 
 */
public class ColumnUtil {
	/** 系统操作的负荷日志是否从0点开始。 */
	public static final boolean DAY_LOAD_CURVE_START_WITH_ZERO = false;
	/** 96点负荷日志的列名。 */
	public static final String[] DAY_LOAD_CURVE_96COLUMN = new String[96];
	static {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		Calendar calendar = Calendar.getInstance();
		calendar.set(2000, 0, 1, 0, 0, 0);
		if (!DAY_LOAD_CURVE_START_WITH_ZERO)
			calendar.add(Calendar.MINUTE, 15);
		for (int i = 0; i < 96; i++) {
			String time = sdf.format(calendar.getTime());
			if (!DAY_LOAD_CURVE_START_WITH_ZERO && "0000".equals(time)) {
				time = "2400";
			}
			DAY_LOAD_CURVE_96COLUMN[i] = "T" + time;
			calendar.add(Calendar.MINUTE, 15);
		}
	}
	
	/**
	 * 获取查询列名,T0000,T0015.....
	 * @return
	 */
	public static String getColumn(){
		StringBuilder column = new StringBuilder();
		for(int i =0 ; i<DAY_LOAD_CURVE_96COLUMN.length; i++){
			column.append(",").append(DAY_LOAD_CURVE_96COLUMN[i]);
		}
		return column.toString();
	}
}
