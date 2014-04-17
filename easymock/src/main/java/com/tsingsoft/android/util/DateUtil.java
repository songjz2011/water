package com.tsingsoft.android.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.tsingsoft.android.common.SysConstant;

/**
 * 日期工具类
 * 
 * @author F.Liu
 * 
 */
public class DateUtil {

	private static SimpleDateFormat yyyyMMddFormat = new SimpleDateFormat("yyyyMMdd");
	
	/**
	 * 根据yyyyMMdd字符串解析成相应的日期
	 * 
	 * @param strDate
	 *            yyyyMMdd格式的日期
	 * @return 转换后的日期
	 */
	public static java.util.Date parseDate(String strDate) {
		java.util.Date date = null;
		try {
			date = getDateFormater().parse(strDate);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return date;
	}

	/**
	 * 获取系统的明天时间（Date类型）
	 * 
	 * @return 明天
	 */
	public static Date getNexDay() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * 获取某一天，i为正如就是今天向后推i天，负数则向前推
	 * 
	 * @param i
	 * @return
	 */
	public static Date getOneDay(int i) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, i);
		return cal.getTime();
	}

	public static Date getOneDay(Date date, int i) {
		Date rtDate = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, i);
		rtDate = cal.getTime();
		return rtDate;
	}

	/**
	 * 获取系统的当天时间（Date类型）
	 * 
	 * @return 当天
	 */
	public static Date getCureDate() {
		Calendar cal = Calendar.getInstance();

		return cal.getTime();
	}

	/**
	 * <pre>
	 * 获取时间所在的前面最近的(往前)96点时刻点的对象，逻辑如下：
	 * 1、负荷从00:00时刻开始时，则是正常逻辑
	 * 2、负荷从00:15时刻开始时，若计算出最近时刻点为24:00时，则返回日期为参数date的前一天，因为没有00:00的数据
	 * 例如：传入的时间为2013年10月10日00点03分，则返回的结果为2013年10月09日 24:00
	 * 3、返回的PointTime.ymd的格式为yyyyMMdd，PointTime.point格式为T0800
	 * </pre>
	 * 
	 * @param date
	 * @return
	 */
	public static PointTime getPrePonitTime96Point(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int index = hour * 4 + minute / 15 - 1;
		// 负荷是否从00:00时刻开始
		if (ColumnUtil.DAY_LOAD_CURVE_START_WITH_ZERO) {
			index++;
		}
		if (index < 0) {
			index = 95;
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		PointTime pointTime = new PointTime();
		pointTime.setYmd(getDateFormater().format(cal.getTime()));
		pointTime.setPoint(ColumnUtil.DAY_LOAD_CURVE_96COLUMN[index]);
		return pointTime;
	}

	private static SimpleDateFormat dateformater;

	private static DateFormat getDateFormater() {
		if (dateformater == null) {
			dateformater = new SimpleDateFormat("yyyyMMdd");
		}
		return dateformater;
	}

	/**
	 * 增加分钟后的时间
	 * 
	 * @param date
	 * @param addMinute
	 * @return
	 */
	public static Date addMinute(Date date, int addMinute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, addMinute);
		return cal.getTime();
	}

	/**
	 * 获取系统的当天时间（字符串类型）
	 * 
	 * @param formatstr
	 *            格式化字符串参数
	 * 
	 * @return 当天
	 */
	public static String getCureDateStr(String formatstr) {
		String fstr = formatstr;

		if (fstr == null) {
			fstr = "yyyy-MM-dd";
		}

		SimpleDateFormat format = new SimpleDateFormat(fstr);
		Date date = DateUtil.getCureDate();
		String dstr = format.format(date);

		return dstr;
	}

	/**
	 * 获取指定日期的前或后推N天（字符串类型），如果传入的参数为空，则返回空
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            跳转天数 负数就是往前推，正数即往后推
	 * @param formatstr
	 *            格式化参数
	 * 
	 * @return 返回字符型日期
	 */
	public static String getMoveDay(String date, int n, String formatstr) {
		String preday = "";
		SimpleDateFormat format = new SimpleDateFormat(formatstr);
		try {
			Date ddate = format.parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(ddate);
			cal.add(Calendar.DAY_OF_MONTH, n);
			Date preddate = cal.getTime();
			preday = format.format(preddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return preday;
	}

	/**
	 * 返回当前日期前后三天+当前天一星期的数据。
	 * 
	 * @param date
	 * @return
	 */
	public static List<String> getSevenDay(String date) {
		String yyyyMMddFormat = "yyyyMMdd";
		List<String> days = new ArrayList<String>();
		// 增加前三天
		days.add(getMoveDay(date, -1, yyyyMMddFormat));
		days.add(getMoveDay(date, -2, yyyyMMddFormat));
		days.add(getMoveDay(date, -3, yyyyMMddFormat));
		days.add(date);
		// 增加后三天
		days.add(getMoveDay(date, 1, yyyyMMddFormat));
		days.add(getMoveDay(date, 2, yyyyMMddFormat));
		days.add(getMoveDay(date, 3, yyyyMMddFormat));
		return days;
	}

	/**
	 * 获取指定日期的前或后推N天（Date类型），如果传入的参数为空，则返回空
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            跳转天数 负数就是往前推，正数即往后推
	 * 
	 * @return 返回日期型
	 */
	public static Date getMoveDay(Date date, int n) {
		Date preddate = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH, n);
			preddate = cal.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preddate;
	}

	/**
	 * 获取当前日期的前一天（字符串类型），如果传入的参数为空，则返回空
	 * 
	 * @param formatstr
	 *            格式化参数
	 * 
	 * @return 前一天
	 */
	public static String getPreDay(String formatstr) {
		String preday = "";
		SimpleDateFormat format = new SimpleDateFormat(formatstr);
		try {
			Date ddate = DateUtil.getCureDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(ddate);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			Date preddate = cal.getTime();
			preday = format.format(preddate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preday;
	}

	/**
	 * 获取指定日期的前一天（字符串类型），如果传入的参数为空，则返回空
	 * 
	 * @param date
	 *            日期
	 * @param formatstr
	 *            格式化参数
	 * 
	 * @return 前一天
	 */
	public static String getPreDay(String date, String formatstr) {
		String preday = "";
		if (date == null || date.equals("")) {
			return preday;
		}
		SimpleDateFormat format = new SimpleDateFormat(formatstr);
		try {
			Date ddate = format.parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(ddate);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			Date preddate = cal.getTime();
			preday = format.format(preddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return preday;
	}

	/**
	 * 获取指定日期的前一天（字符串类型），如果传入的参数为空，则返回空
	 * 
	 * @param date
	 *            日期
	 * @param formatstr
	 *            格式化参数
	 * 
	 * @return 前一天
	 */
	public static String getNextDay(String date, String formatstr) {
		String preday = "";
		if (date == null || date.equals("")) {
			return preday;
		}
		SimpleDateFormat format = new SimpleDateFormat(formatstr);
		try {
			Date ddate = format.parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(ddate);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			Date preddate = cal.getTime();
			preday = format.format(preddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return preday;
	}

	/**
	 * 获取指定日期的上星期同一类型日，如果传入的参数为空，则返回空
	 * 
	 * @param date
	 *            日期
	 * @param formatstr
	 *            格式化参数
	 * 
	 * @return 上周同一类型日
	 */
	public static String getPreWeakDay(String date, String formatstr) {
		String preday = "";
		if (date == null || date.equals("")) {
			return preday;
		}
		SimpleDateFormat format = new SimpleDateFormat(formatstr);
		try {
			Date ddate = format.parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(ddate);
			cal.add(Calendar.DAY_OF_MONTH, -7);
			Date preddate = cal.getTime();
			preday = format.format(preddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return preday;
	}

	/**
	 * 得到月份的最后一天
	 * 
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * 
	 * @return 该月最后一天
	 */
	public static String getLastDayOfMonth(String year, String month) {
		try {
			String[] monthDays = new String[] { "31", "28", "31", "30", "31", "30", "31", "31",
					"30", "31", "30", "31" };
			int m = Integer.parseInt(month);
			int y = Integer.parseInt(year);

			if (((y % 4) == 0) && (m == 2)) {
				return "28";
			} else {
				return monthDays[m - 1];
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获取当前年的上一年，如果传入的参数为空，则返回当前年
	 * 
	 * @param year
	 *            基础年份
	 * 
	 * @return 上一年
	 */
	public static int getPreYear(String year) {
		if ((year == null) || year.equals("")) {
			return getCureYear();
		} else {
			return Integer.parseInt(year) - 1;
		}
	}

	/**
	 * 获取当前年的后一年，如果传入的参数为空，则返回当前年
	 * 
	 * @param year
	 *            基础年份
	 * 
	 * @return 后一年
	 */
	public static String getNextYear(String year) {
		if ((year == null) || year.equals("")) {
			return getCureYear() + "";
		} else {
			return (Integer.parseInt(year) + 1) + "";
		}
	}

	/**
	 * 获取当前年
	 * 
	 * @return 当前年
	 */
	public static String getCureYearStr() {
		return String.valueOf(DateUtil.getCureYear());
	}

	/**
	 * 获取当前年
	 * 
	 * @return 当前年
	 */
	public static int getCureYear() {
		Calendar cal = Calendar.getInstance();

		return cal.get(Calendar.YEAR);
	}

	/**
	 * 获取当前季
	 * 
	 * @return 当前季
	 */
	public static int getCureQuarter() {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int quarter = 1;

		switch (month) {
		case 1:
		case 2:
		case 3:
			quarter = 1;

			break;

		case 4:
		case 5:
		case 6:
			quarter = 2;

			break;

		case 7:
		case 8:
		case 9:
			quarter = 3;

			break;

		case 10:
		case 11:
		case 12:
			quarter = 4;

			break;
		}

		return quarter;
	}

	/**
	 * 获取当前季
	 * 
	 * @return 当前季
	 */
	public static String getCureQuarterStr() {
		return String.valueOf(DateUtil.getCureQuarter());
	}

	/**
	 * 获取下一季
	 * 
	 * @param quarter
	 *            起始季度
	 * 
	 * @return 下一季
	 */
	public static String getNextQuarterStr(String quarter) {
		String s = "";

		try {
			s = Integer.parseInt(quarter) + 1 + "";
		} catch (Exception e) {
		}

		return s;
	}

	/**
	 * 获取当前月（数值型）
	 * 
	 * @return 当前月
	 */
	public static int getCureMonth() {
		Calendar cal = Calendar.getInstance();

		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取当前月(字符串)
	 * 
	 * @return 当前月
	 */
	public static String getCureMonthStr() {
		String monthStr = null;
		int month = DateUtil.getCureMonth();
		monthStr = String.valueOf(month);

		if (monthStr.length() < 2) {
			monthStr = "0" + monthStr;
		}

		return monthStr;
	}

	/**
	 * 获取下一月 (字符串型)
	 * 
	 * @return 下一月
	 */
	public static String getNextMonthStr(String month) {
		String s = "";

		try {
			if ((Integer.parseInt(month) + 1) < 10) {
				s = "0" + (Integer.parseInt(month) + 1);
			} else {
				s = (Integer.parseInt(month) + 1) + "";
			}

			if ("12".equals(month)) {
				s = "01";
			}
		} catch (Exception e) {
		}

		return s;
	}

	/**
	 * 获取当前月
	 * 
	 * @return 当前月
	 */
	public static String getStrCureMonth() {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;

		if (month < 10) {
			return "0" + month;
		} else {
			return month + "";
		}
	}

	/**
	 * 获取当前日
	 * 
	 * @return 当前日
	 */
	public static int getCureDay() {
		Calendar cal = Calendar.getInstance();

		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取当前日
	 * 
	 * @return 当前日
	 */
	public static String getCureDayStr() {
		Calendar cal = Calendar.getInstance();

		int day = cal.get(Calendar.DAY_OF_MONTH);
		if (day < 10) {
			return "0" + day;
		} else {
			return day + "";
		}
	}

	/**
	 * 获取当前小时
	 * 
	 * @return 当前小时
	 */
	public static String getCureHourStr() {
		Calendar cal = Calendar.getInstance();

		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if (hour < 10) {
			return "0" + hour;
		} else {
			return hour + "";
		}
	}

	/**
	 * 获取当前分钟
	 * 
	 * @return 当前分钟
	 */
	public static String getCureMinuteStr() {
		Calendar cal = Calendar.getInstance();

		int minute = cal.get(Calendar.MINUTE);
		if (minute < 10) {
			return "0" + minute;
		} else {
			return minute + "";
		}
	}

	/**
	 * 获取系统的当月第一天
	 * 
	 * @return DOCUMENT ME!
	 */
	public static Date getFirstMonthDay() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);

		return cal.getTime();
	}

	/**
	 * 取得两个日期之间的所有日期集合，包含起始日期和结束日期
	 * 
	 * @param startdate
	 *            起始日期
	 * @param enddate
	 *            结束日期
	 * @param formatstr
	 *            格式化字符串
	 * 
	 * @return 日期集合
	 */
	public static List<String> getListBetweenDay(String startdate, String enddate, String formatstr) {
		List<String> list = new ArrayList<String>();

		if ((startdate == null) || (enddate == null)) {
			return null;
		}

		String fstr = formatstr;

		if (fstr == null) {
			fstr = "yyyy-MM-dd";
		}

		SimpleDateFormat format = new SimpleDateFormat(fstr);

		try {
			Date dstartdate = format.parse(startdate);
			Date denddate = format.parse(enddate);
			Calendar startcal = Calendar.getInstance();
			startcal.setTime(dstartdate);

			for (Date date = dstartdate; date.before(denddate) || date.equals(denddate);) {
				list.add(format.format(date));
				startcal.add(Calendar.DAY_OF_MONTH, 1);
				date = startcal.getTime();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 取得两个日期之间的所有日期集合，包含起始日期和结束日期
	 * 
	 * @param startdate
	 *            起始日期
	 * @param enddate
	 *            结束日期
	 * 
	 * @return 日期集合
	 */
	public static List<String> getListBetweenDay(String startdate, String enddate) {
		List<String> list = new ArrayList<String>();

		if ((startdate == null) || (enddate == null)) {
			return null;
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date dstartdate = format.parse(startdate);

			Date denddate = format.parse(enddate);
			Calendar startcal = Calendar.getInstance();
			startcal.setTime(dstartdate);

			for (Date date = dstartdate; date.before(denddate) || date.equals(denddate);) {
				list.add(format.format(date));
				startcal.add(Calendar.DAY_OF_MONTH, 1);
				date = startcal.getTime();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 返回指定日期和其后n天日期list
	 * 
	 * @param ymd
	 *            日期
	 * @param n
	 *            天数
	 * 
	 * @return 日期集合
	 */
	public static List<String> getDays(String ymd, int n) {
		return DateUtil.getDays(ymd, n, "yyyyMMdd");
	}

	/**
	 * 返回指定日期和其后n天日期list
	 * 
	 * @param ymd
	 *            日期
	 * @param n
	 *            天数
	 * @param formatstr
	 *            格式化字符串
	 * 
	 * @return 日期集合
	 */
	public static List<String> getDays(String ymd, int n, String formatstr) {
		/** 用于返回的list */
		List<String> dayList = new ArrayList<String>();
		String toDate = DateUtil.getMoveDay(ymd, n, formatstr);

		if (n >= 0) {
			dayList = DateUtil.getListBetweenDay(ymd, toDate, formatstr);
		} else {
			dayList = DateUtil.getListBetweenDay(toDate, ymd, formatstr);
		}
		return dayList;
	}

	/**
	 * 取得两个日期之间的相隔天数
	 * 
	 * @param startdate
	 *            起始日期
	 * @param enddate
	 *            结束日期
	 * @param formatstr
	 *            格式化字符串
	 * 
	 * @return 相隔天数
	 */
	public static Integer getDayCountBetweenDay(String startdate, String enddate, String formatstr) {
		int dayCOunt = 0;
		List list = DateUtil.getListBetweenDay(startdate, enddate, formatstr);
		if (list != null && list.size() > 0) {
			dayCOunt = list.size() - 1;
		}
		return dayCOunt;
	}

	/**
	 * 取得指定季度的月份
	 * 
	 * @param quarter
	 *            季度
	 * 
	 * @return 月份集合
	 */
	public static List<String> getMonthByQuater(String quarter) {
		List<String> list = null;

		if (quarter == null) {
			return null;
		}

		try {
			int iquarter = 1;
			iquarter = Integer.valueOf(quarter).intValue();

			// System.out.print("iquarter"+iquarter);
			switch (iquarter) {
			case 1:
				list = new ArrayList<String>();
				list.add("01");
				list.add("02");
				list.add("03");

				break;

			case 2:
				list = new ArrayList<String>();
				list.add("04");
				list.add("05");
				list.add("06");

				break;

			case 3:
				list = new ArrayList();
				list.add("07");
				list.add("08");
				list.add("09");

				break;

			case 4:
				list = new ArrayList();
				list.add("10");
				list.add("11");
				list.add("12");

				break;

			default:
				list = new ArrayList();
				list.add("01");
				list.add("02");
				list.add("03");

				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 返回月份list
	 * 
	 * @return 月份集合
	 */
	public List<String> getMonthList() {
		List<String> monthList = new ArrayList<String>();

		for (int j = 1; j <= 12; j++) {
			if (j < 10) {
				monthList.add("0" + j);
			} else {
				monthList.add("" + j);
			}
		}

		return monthList;
	}

	/**
	 * 返回指定月份所在的季度
	 * 
	 * @param month
	 *            月份
	 * 
	 * @return 季度
	 */
	public static String getQuarter(String month) {
		int m = Integer.parseInt(month);

		if (m <= 3) {
			return "1";
		} else if (m <= 6) {
			return "2";
		} else if (m <= 9) {
			return "3";
		} else if (m <= 12) {
			return "4";
		}

		return null;
	}

	/**
	 * 返回指定年份和季度的年月数组
	 * 
	 * @param yq
	 *            年季字符串
	 * 
	 * @return 年月数组
	 */
	public static String[] getYms(String yq) {
		String[] yms = new String[3];

		for (int i = 0; i < 3; i++) {
			yms[i] = yq.substring(0, 4)
					+ String.valueOf(((Integer.parseInt(yq.substring(4)) - 1) * 3) + i + 101)
							.substring(1);
		}

		return yms;
	}

	/**
	 * 返回年月数组
	 * 
	 * @param yq
	 * 
	 * @return 年月数组
	 */
	public static String[] getYmds(String yq) {
		String[] yms = new String[2];
		String year = yq.substring(0, 4);
		String q = yq.substring(4);
		int qint = Integer.parseInt(q);
		if (qint == 1) {
			yms[0] = year + "0101";
			yms[1] = year + "0331";
		} else if (qint == 2) {
			yms[0] = year + "0401";
			yms[1] = year + "0630";
		} else if (qint == 3) {
			yms[0] = year + "0701";
			yms[1] = year + "0930";
		} else if (qint == 4) {
			yms[0] = year + "1001";
			yms[1] = year + "1231";
		}
		return yms;
	}

	/**
	 * 取得指定季度的月份字符串
	 * 
	 * @param quarter
	 *            季度
	 * 
	 * @return 月份字符串
	 */
	public static String getMonthStrByQuater(String quarter) {
		String monthStr = "";
		List monthL = DateUtil.getMonthByQuater(quarter);

		if (monthL != null) {
			for (int i = 0; i < monthL.size(); i++) {
				monthStr += (",'" + (String) monthL.get(i) + "'");
			}
		}

		monthStr = monthStr.substring(1);

		return monthStr;
	}

	/**
	 * 将数据库中取出的yyyyMMdd的日期转换为yyyy-MM-dd方式显示
	 * 
	 * @param date
	 *            待转换日期字符串
	 * @return 转换格式后的日期
	 */
	public static String getFormatStrDate(String date) {
		String s = "";

		if ((date == null) || (date.length() < 8)) {
			return s;
		} else {
			s = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
		}

		return s;
	}

	/**
	 * 将yyyy-MM-dd的日期转换转换为yyyyMMdd的方式显示
	 * 
	 * @param date
	 *            待转换日期字符串
	 * 
	 * @return 转换格式后的日期
	 */
	public static String getFormatSysDate(String date) {
		String s = "";

		if ((date == null) || (date.length() < 10)) {
			return s;
		} else {
			s = date.substring(0, 4) + date.substring(5, 7) + date.substring(8, 10);
		}

		return s;
	}

	/**
	 * 将数据库中取出的HHmm的日期转换为HH:mm方式显示
	 * 
	 * @param time
	 *            待转换时间字符串
	 * 
	 * @return 转换格式后的时间
	 */
	public static String getFormatStrTime(String time) {
		String s = "";

		if ((time == null) || (time.length() < 4)) {
			return s;
		} else {
			s = time.substring(0, 2) + ":" + time.substring(2, 4);
		}

		return s;
	}

	/**
	 * 将HH:mm的日期转换转换为HHmm的方式显示
	 * 
	 * @param time
	 *            待转换时间字符串
	 * 
	 * @return DOCUMENT ME!
	 */
	public static String getFormatSysTime(String time) {
		String s = "";

		if ((time == null) || (time.length() < 5)) {
			return s;
		} else {
			s = time.substring(0, 2) + time.substring(3, 5);
		}

		return s;
	}

	/**
	 * 将需要显示的月份格式化为两位字符
	 * 
	 * @param month
	 *            月份
	 * 
	 * @return 转换格式后的月份
	 */
	public static String getFormatMonth(String month) {
		String s = "";

		if ((month == null) || (month.length() > 2)) {
			return s;
		} else {
			if (month.length() < 2) {
				s = "0" + month;
			} else {
				s = month;
			}
		}

		return s;
	}

	/**
	 * 将需要显示的月份格式化为两位字符
	 * 
	 * @param month
	 *            月份
	 * @return 转换格式后的月份
	 */
	public static String getFormatMonth(int month) {
		String s = "";

		if ((month > 12) || (month < 0)) {
			return s;
		} else {
			if (month < 10) {
				s = "0" + month;
			} else {
				s = month + "";
			}
		}

		return s;
	}

	/**
	 * 计算月份天数
	 * 
	 * @param year
	 *            年份
	 * @param month
	 *            月度
	 * @return 月总天数
	 */
	public static int countDaysOfMonth(int year, int month) {
		int days = 0;

		try {
			month = month - 1;

			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.MONTH, month);
			days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return days;
	}

	/**
	 * 计算月份天数
	 * 
	 * @param year
	 *            年份
	 * @param month
	 *            月度
	 * @return 月总天数
	 */
	public static int countDaysOfMonth(String year, String month) {
		int days = 0;

		try {
			if ((year != null) && (month != null)) {
				int yearI = Integer.parseInt(year);
				int monthI = Integer.parseInt(month);
				days = DateUtil.countDaysOfMonth(yearI, monthI);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return days;
	}

	/**
	 * 计算季度天数
	 * 
	 * @param year
	 *            年份
	 * @param quarter
	 *            季度
	 * @return 季总天数
	 */
	public static int countDaysOfQuarter(String year, String quarter) {
		int days = 0;

		try {
			if ((year != null) && (quarter != null)) {
				List monthL = DateUtil.getMonthByQuater(quarter);

				if (monthL != null) {
					for (int i = 0; i < monthL.size(); i++) {
						String month = (String) monthL.get(i);
						int dayI = DateUtil.countDaysOfMonth(year, month);
						days += dayI;

						// System.out.println(days+" y:"+year+"   m:"+month);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return days;
	}

	/**
	 * 将字符串类型 转换为日期类型
	 * 
	 * @param strdate
	 *            字符串类型日期
	 * @param formatstr
	 *            格式化参数类型 。为空系统默认采用yyyy-MM-dd
	 * @return 日期
	 */
	public static Date getDate(String strdate, String formatstr) {
		String fstr = "yyyy-MM-dd";

		if (formatstr != null) {
			fstr = formatstr;
		}

		SimpleDateFormat format = new SimpleDateFormat(fstr);
		Date date = null;

		if (strdate == null) {
			return date;
		}

		try {
			date = format.parse(strdate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	public static String transDateFormat(String strdate, String soureFormatstr, String resultfomater) {
		String fstr = "yyyyMMdd";

		if (soureFormatstr == null) {
			soureFormatstr = fstr;
		}
		if (resultfomater == null) {
			resultfomater = fstr;
		}
		SimpleDateFormat format = new SimpleDateFormat(fstr);
		SimpleDateFormat resultformat = new SimpleDateFormat(resultfomater);
		String date = null;

		if (strdate == null) {
			return "";
		}

		try {
			Date d = format.parse(strdate);
			date = resultformat.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 将日期类型 转换为字符串类型
	 * 
	 * @param date
	 *            日期
	 * @param formatstr
	 *            格式化参数类型。为空系统默认采用yyyy-MM-dd
	 * @return 日期
	 */
	public static String getStrDate(Date date, String formatstr) {
		String fstr = "yyyy-MM-dd";

		if (formatstr != null) {
			fstr = formatstr;
		}

		SimpleDateFormat format = new SimpleDateFormat(fstr);
		String strdate = "";

		if (date == null) {
			return strdate;
		}

		try {
			strdate = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return strdate;
	}

	/**
	 * 获得当前时刻最近的一个断面时刻(96点)
	 * 
	 * @return 时刻
	 */
	public static String getFloorTime() {
		String time = "";
		time = getCureDateStr("HHmm");
		String hour = time.substring(0, 2);// 当前小时
		String minute = time.substring(2, 4);// 当前分钟
		int iminute = Integer.parseInt(minute);
		if (iminute >= 0 && iminute < 15) {
			time = hour + "00";
		} else if (iminute >= 15 && iminute < 30) {
			time = hour + "15";
		} else if (iminute >= 30 && iminute < 45) {
			time = hour + "30";
		} else if (iminute >= 45) {
			time = hour + "45";
		}
		return time;
	}

	/**
	 * 获得当前时刻最近的上一个断面时刻(96点)
	 * 
	 * @return 时刻
	 */
	public static String getPreFloorTime() {
		String time = "";
		time = getCureDateStr("HHmm");
		String hour = time.substring(0, 2);// 当前小时
		String minute = time.substring(2, 4);// 当前分钟
		int iminute = Integer.parseInt(minute);
		if (iminute >= 0 && iminute < 15 && Integer.parseInt(hour) == 0) {
			time = hour + "00";
		}
		if (iminute >= 0 && iminute < 15 && Integer.parseInt(hour) > 0) {
			if ((Integer.parseInt(hour) - 1) < 10) {
				time = "0" + (Integer.parseInt(hour) - 1) + "45";
			} else {
				time = (Integer.parseInt(hour) - 1) + "45";
			}
		} else if (iminute >= 15 && iminute < 30) {
			time = hour + "00";
		} else if (iminute >= 30 && iminute < 45) {
			time = hour + "15";
		} else if (iminute >= 45) {
			time = hour + "30";
		}
		return time;
	}

	/**
	 * 格式化数字，将单位数字格式化为双位字符显示
	 * 
	 * @param number
	 *            数字
	 * @return
	 */
	public static String formatDoubleNumber(int number) {
		String str = "";

		if (number < 10) {
			str = "0" + number;
		} else {
			str = "" + number;
		}

		return str;
	}

	/**
	 * 获取一天的所有小时数
	 * 
	 * @return 小时总数
	 */
	public static List<String> getHourList() {
		List<String> hourList = new ArrayList<String>();
		for (int i = 1; i < 13; i++) {
			if (i < 10) {
				hourList.add("0" + i);
			} else {
				hourList.add("" + i);
			}
		}
		return hourList;
	}

	/**
	 * 返回一个季度的小时数
	 * 
	 * @param year
	 *            年份
	 * @param quarter
	 *            季度
	 * 
	 * @return 小时总数
	 */
	public static int getQuarterHours(String year, String quarter) {
		try {
			int y = Integer.parseInt(year);
			int q = Integer.parseInt(quarter);

			if (((y % 4) == 0) && (q == 1)) {
				return (31 + 29 + 31) * 24;
			} else {
				if (q == 1) {
					return (31 + 28 + 31) * 24;
				} else if (q == 2) {
					return (30 + 31 + 30) * 24;
				} else if (q == 3) {
					return (31 + 31 + 30) * 24;
				} else if (q == 4) {
					return (31 + 30 + 31) * 24;
				}
			}

			return 0;
		} catch (Exception e) {
			e.printStackTrace();

			return 0;
		}
	}

	/**
	 * 返回一年的小时数
	 * 
	 * @param year
	 *            年份
	 * 
	 * @return 小时总数
	 */
	public int getYearHours(String year) {
		try {
			int y = Integer.parseInt(year);

			if ((y % 4) == 0) {
				return 366 * 24;
			} else {
				return 365 * 24;
			}
		} catch (Exception e) {
			e.printStackTrace();

			return 0;
		}
	}

	/**
	 * 获取一个小时内的所有点数
	 * 
	 * @return 时刻点集合
	 */
	public static List<String> getBreakPointList() {
		List<String> minuteList = new ArrayList<String>();
		for (int i = 0; i < 60;) {
			if (i < 10) {
				minuteList.add("0" + i);
			} else {
				minuteList.add("" + i);
			}
			i = i + 15;
		}
		return minuteList;
	}

	/**
	 * 获取指定时间段的年份
	 * 
	 * @param fromYmd
	 *            起始日期
	 * @param toYmd
	 *            结束日期
	 * 
	 * @return 年度集合
	 */
	public static List<String> getYears(String fromYmd, String toYmd) {
		List<String> result = new ArrayList<String>();
		int beginY = Integer.parseInt(fromYmd.substring(0, 4));
		int endY = Integer.parseInt(toYmd.substring(0, 4));

		while (beginY <= endY) {
			result.add(beginY + "");
			beginY++;
		}

		return result;
	}

	/**
	 * 得到季度数组
	 * 
	 * @param fromYmd
	 *            起始年
	 * @param toYmd
	 *            终止年
	 * 
	 * @return 季度数组
	 */
	public static List<String> getYqs(String fromYmd, String toYmd) {
		int fY = 0;
		int tY = 0;
		int fQ = 0;
		int tQ = 0;
		ArrayList<String> yqArr = new ArrayList<String>();

		try {
			fY = Integer.parseInt(fromYmd.substring(0, 4));
			tY = Integer.parseInt(toYmd.substring(0, 4));
			fQ = Integer.parseInt(DateUtil.getQuarter(fromYmd.substring(4, 6)));
			tQ = Integer.parseInt(DateUtil.getQuarter(toYmd.substring(4, 6)));

			for (int y = fY; y <= tY; y++) {
				for (int q = 1; q <= 4; q++) {
					if ((y == fY) && (q < fQ)) {
						continue;
					}

					if ((y == tY) && (q > tQ)) {
						break;
					}

					yqArr.add(y + String.valueOf(q));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return yqArr;
	}

	/**
	 * 返回指定日期范围内的所有年月数组
	 * 
	 * @param fromYm
	 *            起始日期
	 * @param toYm
	 *            结束日期
	 * 
	 * @return 日期集合
	 */
	public static List<String> getYM(String fromYm, String toYm) {
		List<String> result = new ArrayList<String>();
		int fY = Integer.parseInt(fromYm.substring(0, 4));
		int fM = Integer.parseInt(fromYm.substring(4));
		int tY = Integer.parseInt(toYm.substring(0, 4));
		int tM = Integer.parseInt(toYm.substring(4));

		while (fY <= tY) {
			if (fY == tY) {
				while (fM <= tM) {
					result.add(fY + (fM + 100 + "").substring(1));
					fM++;
				}
			} else {
				while (fM <= 12) {
					result.add(fY + (fM + 100 + "").substring(1));
					fM++;
				}
			}

			fM = 1;
			fY++;
		}

		return result;
	}

	/**
	 * 返回指定日期（周一）所在周的周六和周日日期
	 * 
	 * @param ymd
	 *            日期
	 * 
	 * @return 周六、周日
	 */
	public static List<String> getRestDays(String ymd) {
		/** 用于返回的list */
		List<String> dayList = new ArrayList<String>();
		String year = null;
		String month = null;
		String day = null;
		String date = null;

		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.YEAR, Integer.parseInt(ymd.substring(0, 4)));
		ca.set(Calendar.MONTH, Integer.parseInt(ymd.substring(4, 6)) - 1);
		ca.set(Calendar.DAY_OF_MONTH, Integer.parseInt(ymd.substring(6)));

		ca.add(Calendar.DAY_OF_MONTH, 5);

		for (int i = 0; i < 2; i++) {
			year = "" + ca.get(Calendar.YEAR);
			month = (ca.get(Calendar.MONTH) + 1 + 100 + "").substring(1);
			day = (ca.get(Calendar.DAY_OF_MONTH) + 100 + "").substring(1);
			date = year + month + day;
			dayList.add(date);
			ca.add(Calendar.DAY_OF_MONTH, 1);
		}

		return dayList;
	}

	/**
	 * 返回一年中的所有周一日期
	 * 
	 * @param year
	 *            年份
	 * @return 周一集合
	 */
	public List<String> getMondayList(String year) {
		/** 用于返回的list */
		List<String> mondayList = new ArrayList<String>();
		/** 月 */
		String month = null;
		/** 日 */
		String day = null;
		/** 日期 */
		String date = null;

		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.YEAR, Integer.parseInt(year));
		ca.set(Calendar.MONTH, 0);
		ca.set(Calendar.DAY_OF_MONTH, 1);
		if (ca.get(Calendar.DAY_OF_WEEK) == 2) {
			mondayList.add(year + "0101");
		}
		while (Integer.parseInt("" + ca.get(Calendar.YEAR) + (ca.get(Calendar.MONTH) + 1)
				+ ca.get(Calendar.DAY_OF_MONTH)) < Integer.parseInt(year + 12 + 31)) {
			ca.add(Calendar.DAY_OF_MONTH, 1);
			if (ca.get(Calendar.DAY_OF_WEEK) != 2) {
				continue;
			}
			month = (ca.get(Calendar.MONTH) + 1 + 100 + "").substring(1);
			day = (ca.get(Calendar.DAY_OF_MONTH) + 100 + "").substring(1);
			date = year + month + day;
			mondayList.add(date);
		}
		return mondayList;
	}

	/**
	 * 得到某个月的星期几的日期List
	 * 
	 * @param ym
	 *            年月
	 * @param dateType
	 *            星期几 1-星期日......7-星期六
	 * 
	 * @return 日期list
	 */
	public static List<String> getWeekYmds(String ym, int dateType) {
		List<String> dayList = new ArrayList<String>();
		String lastYmd = getLastDayOfMonth(ym.substring(0, 4), ym.substring(4));
		Calendar calendar = Calendar.getInstance();
		Calendar tocalendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(ym.substring(0, 4)));
		calendar.set(Calendar.MONTH, Integer.parseInt(ym.substring(4)) - 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		tocalendar.set(Calendar.YEAR, Integer.parseInt(ym.substring(0, 4)));
		tocalendar.set(Calendar.MONTH, Integer.parseInt(ym.substring(4)) - 1);
		tocalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(lastYmd));

		do {
			if (calendar.get(Calendar.DAY_OF_WEEK) == dateType) {
				dayList.add(ym.substring(0, 4) + ym.substring(4)
						+ (calendar.get(Calendar.DAY_OF_MONTH) + 100 + "").substring(1));
			}

			calendar.add(Calendar.DATE, 1);
		} while (!calendar.after(tocalendar));

		return dayList;
	}

	/**
	 * 得到某年某季所有周六或周日数组
	 * 
	 * @param yq
	 *            年季
	 * @param type
	 *            类型 1周日 7周六
	 * 
	 * @return 工作日数组
	 */
	public static String[] getQSunOrSatYmds(String yq, int type) {
		String year = yq.substring(0, 4);
		String quarter = yq.substring(4);
		String fromYmd = "";
		String toYmd = "";
		String[] ymds = null;
		ArrayList<String> ymdArr = new ArrayList<String>();

		try {
			fromYmd = year
					+ String.valueOf(((Integer.parseInt(quarter) - 1) * 3) + 101).substring(1)
					+ "01";
			toYmd = year
					+ String.valueOf(((Integer.parseInt(quarter) - 1) * 3) + 103).substring(1)
					+ DateUtil.getLastDayOfMonth(year,
							String.valueOf(((Integer.parseInt(quarter) - 1) * 3) + 103)
									.substring(1));

			int fromY = Integer.parseInt(fromYmd.substring(0, 4));
			int fromM = Integer.parseInt(fromYmd.substring(4, 6)) - 1;
			int fromD = Integer.parseInt(fromYmd.substring(6));
			int toY = Integer.parseInt(toYmd.substring(0, 4));
			int toM = Integer.parseInt(toYmd.substring(4, 6)) - 1;
			int toD = Integer.parseInt(toYmd.substring(6));

			GregorianCalendar fromCal = new GregorianCalendar(fromY, fromM, fromD);
			GregorianCalendar toCal = new GregorianCalendar(toY, toM, toD);

			// 得到所有天
			do {
				if (fromCal.get(Calendar.DAY_OF_WEEK) == type) {
					ymdArr.add("" + fromCal.get(Calendar.YEAR)
							+ String.valueOf(fromCal.get(Calendar.MONTH) + 101).substring(1)
							+ String.valueOf(fromCal.get(Calendar.DAY_OF_MONTH) + 100).substring(1));
				}

				fromCal.add(Calendar.DATE, 1);
			} while (!fromCal.after(toCal));

			ymds = new String[ymdArr.size()];

			for (int i = 0; i < ymds.length; i++) {
				ymds[i] = (String) ymdArr.get(i);
			}

			return ymds;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 得到某年某季所有工作日数组
	 * 
	 * @param yq
	 *            年季
	 * 
	 * @return 工作日数组
	 */
	public static String[] getQWorkYmds(String yq) {
		String year = yq.substring(0, 4);
		String quarter = yq.substring(4);
		String fromYmd = "";
		String toYmd = "";
		String[] ymds = null;
		ArrayList<String> ymdArr = new ArrayList<String>();

		try {
			fromYmd = year
					+ String.valueOf(((Integer.parseInt(quarter) - 1) * 3) + 101).substring(1)
					+ "01";
			toYmd = year
					+ String.valueOf(((Integer.parseInt(quarter) - 1) * 3) + 103).substring(1)
					+ DateUtil.getLastDayOfMonth(year,
							String.valueOf(((Integer.parseInt(quarter) - 1) * 3) + 103)
									.substring(1));

			int fromY = Integer.parseInt(fromYmd.substring(0, 4));
			int fromM = Integer.parseInt(fromYmd.substring(4, 6)) - 1;
			int fromD = Integer.parseInt(fromYmd.substring(6));
			int toY = Integer.parseInt(toYmd.substring(0, 4));
			int toM = Integer.parseInt(toYmd.substring(4, 6)) - 1;
			int toD = Integer.parseInt(toYmd.substring(6));

			GregorianCalendar fromCal = new GregorianCalendar(fromY, fromM, fromD);
			GregorianCalendar toCal = new GregorianCalendar(toY, toM, toD);

			// 得到所有天
			do {
				if ((fromCal.get(Calendar.DAY_OF_WEEK) >= 2)
						&& (fromCal.get(Calendar.DAY_OF_WEEK) <= 6)) {
					ymdArr.add("" + fromCal.get(Calendar.YEAR)
							+ String.valueOf(fromCal.get(Calendar.MONTH) + 101).substring(1)
							+ String.valueOf(fromCal.get(Calendar.DAY_OF_MONTH) + 100).substring(1));
				}

				fromCal.add(Calendar.DATE, 1);
			} while (!fromCal.after(toCal));

			ymds = new String[ymdArr.size()];

			for (int i = 0; i < ymds.length; i++) {
				ymds[i] = (String) ymdArr.get(i);
			}

			return ymds;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 得到某年某月的工作日数组
	 * 
	 * @param ym
	 *            年月
	 * 
	 * @return 工作日字符串
	 */
	public static String[] getMWorkYmds(String ym) {
		String year = ym.substring(0, 4);
		String month = ym.substring(4);
		String fromYmd = "";
		String toYmd = "";
		String[] ymds = null;
		ArrayList<String> ymdArr = new ArrayList<String>();

		try {
			fromYmd = year + month + "01";
			toYmd = year + month + DateUtil.getLastDayOfMonth(year, month);

			int fromY = Integer.parseInt(fromYmd.substring(0, 4));
			int fromM = Integer.parseInt(fromYmd.substring(4, 6)) - 1;
			int fromD = Integer.parseInt(fromYmd.substring(6));
			int toY = Integer.parseInt(toYmd.substring(0, 4));
			int toM = Integer.parseInt(toYmd.substring(4, 6)) - 1;
			int toD = Integer.parseInt(toYmd.substring(6));

			GregorianCalendar fromCal = new GregorianCalendar(fromY, fromM, fromD);
			GregorianCalendar toCal = new GregorianCalendar(toY, toM, toD);

			// 得到所有天
			do {
				if ((fromCal.get(Calendar.DAY_OF_WEEK) >= 2)
						&& (fromCal.get(Calendar.DAY_OF_WEEK) <= 6)) {
					ymdArr.add("" + fromCal.get(Calendar.YEAR)
							+ String.valueOf(fromCal.get(Calendar.MARCH) + 101).substring(1)
							+ String.valueOf(fromCal.get(Calendar.DAY_OF_MONTH) + 100).substring(1));
				}

				fromCal.add(Calendar.DATE, 1);
			} while (!fromCal.after(toCal));

			ymds = new String[ymdArr.size()];

			for (int i = 0; i < ymds.length; i++) {
				ymds[i] = (String) ymdArr.get(i);
			}

			return ymds;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 返回指定时间段的特定日期List.比如所有周一(周二、周三....)
	 * 
	 * @param fromYmd
	 *            起始日期
	 * @param toYmd
	 *            中止日期
	 * @param type
	 *            日期类型:1 周日 2 周一 3 周二 4 周三 5 周四 6 周五 7 周六
	 * @param flag
	 *            是否包括起始日前面的最近一个指定特殊日期 0:不包括 1:包括
	 * 
	 * @return 日期集合
	 */
	public static List<String> getSpecificDayList(String fromYmd, String toYmd, int type, int flag) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		List<String> resultList = new ArrayList<String>();
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(Integer.parseInt(fromYmd.substring(0, 4)),
				Integer.parseInt(fromYmd.substring(4, 6)) - 1,
				Integer.parseInt(fromYmd.substring(6)));

		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(Integer.parseInt(toYmd.substring(0, 4)),
				Integer.parseInt(toYmd.substring(4, 6)) - 1, Integer.parseInt(toYmd.substring(6)));

		if ((flag == 1) && (calendar1.get(Calendar.DAY_OF_WEEK) != type)) {
			while (calendar1.get(Calendar.DAY_OF_WEEK) != type) {
				calendar1.add(Calendar.DATE, -1);
			}

			resultList.add(sdf.format(calendar1.getTime()));
			calendar1.add(Calendar.DATE, 1);
		}

		while (!calendar1.after(calendar2)) {
			if (calendar1.get(Calendar.DAY_OF_WEEK) == type) {
				resultList.add(sdf.format(calendar1.getTime()));
			}

			calendar1.add(Calendar.DATE, 1);
		}

		return resultList;
	}

	/**
	 * 返回起始结束日期期间所有日期
	 * 
	 * @param fromYmd
	 *            起始日期
	 * @param toYmd
	 *            结束日期
	 * 
	 * @return 日期集合
	 */
	public static List<String> getYmdList(String fromYmd, String toYmd) {
		List<String> ymdList = new ArrayList<String>();
		Calendar fromCa = Calendar.getInstance();
		Calendar toCa = Calendar.getInstance();

		fromCa.set(Integer.parseInt(fromYmd.substring(0, 4)),
				Integer.parseInt(fromYmd.substring(4, 6)) - 1,
				Integer.parseInt(fromYmd.substring(6)));
		toCa.set(Integer.parseInt(toYmd.substring(0, 4)),
				Integer.parseInt(toYmd.substring(4, 6)) - 1, Integer.parseInt(toYmd.substring(6)));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		while (!toCa.before(fromCa)) {
			ymdList.add(sdf.format(fromCa.getTime()));
			fromCa.add(Calendar.DATE, 1);
		}

		return ymdList;
	}

	public static String pointsQueryStrHasT(List<String> points) {
		StringBuilder sb = new StringBuilder();
		if (points != null && points.size() > 0) {
			for (int i = 0; i < points.size(); i++) {
				String s = points.get(i);
				if (i == points.size() - 1) {
					// 最后一个
					sb.append(s);
				} else {
					sb.append(s + ",");
				}
			}
		}
		return sb.toString();
	}

	public static String getLocalDate(String ymd) {
		return ymd.substring(0, 4) + "年" + ymd.substring(4, 6) + "月" + ymd.substring(6, 8) + "日";
	}

	public static String formatYYYYMMDD(Date date) {
		return yyyyMMddFormat.format(date);
	}

	/**
	 * 根据指定的转化模式，转换日期成字符串
	 * 
	 * @param date
	 *            需要转换的日期
	 * @param pattern
	 *            转换模式，请参考javadoc中的DateFormater部分
	 * @return 转换后的字符串
	 */
	public final static String formatDate(java.util.Date date, String pattern) {
		SimpleDateFormat formater = new SimpleDateFormat(pattern);
		return formater.format(date);
	}

	/**
	 * 根据旧的时间格式字符串，转化成规定格式的字符串。
	 * 
	 * @param oldFormatStr
	 * @param pattern
	 * @return
	 */
	public final static String formatDate(String oldFormatStr, String pattern) {
		SimpleDateFormat formater = new SimpleDateFormat(pattern);
		Date date = new Date();
		try {
			date = formater.parse(oldFormatStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String ymd = formatDate(date, pattern);
		return ymd;
	}

	public final static String formatDate(String oldFormatStr) {
		String month = oldFormatStr.substring(4, 6);
		String day = oldFormatStr.substring(6, 8);
		String md = month + "月" + day + "日";
		return md;
	}

	/**
	 * 根据指定的转化模式，转换成日期
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	public final static Date parse(String str, String pattern) {
		SimpleDateFormat formater = new SimpleDateFormat(pattern);
		try {
			return formater.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * <pre>
	 * 获取根据ymd和point左右偏移结果，
	 * 逻辑例如：
	 * 1、不跨天：ymd=20131010,point=0600,OffsetPointNum=4
	 * 则返回的结果为：20131010=0500,....,0700
	 * 2、跨天（时刻点从0000开始）：ymd=20131010,point=0000,OffsetPointNum=4
	 * 则返回的结果为：20131009=2300,....,2345；20131010=0000,....,0100
	 * 3、跨天（时刻点从0015开始）：ymd=20131010,point=0015,OffsetPointNum=4
	 * 则返回的结果为：20131009=2315,....,2400；20131010=0015,....,0115
	 * 4、结果时刻点总的个数为OffsetPointNum*2 + 1，因为包含point点
	 * </pre>
	 * 
	 * @param ymd
	 *            :日期（格式yyyyMMdd） ：时刻点对象
	 * @param point
	 *            ：ymd的时刻点(必须为96中的一个点)
	 * @param offsetPointNum
	 *            ：左右偏移的点数，范围为1<=OffsetPointNum，超出范围，返回空集合
	 * @return：key:日期，value：该日期的时刻点值
	 */
	public static Map<String, List<String>> getPointTimeOffset96Point(String ymd, String point,
			int offsetPointNum) {
		Map<String, List<String>> result = new TreeMap<String, List<String>>();
		if (offsetPointNum < 1) {
			return result;
		}
		Integer pointIndex = findIndexFor96Point(point);
		if (pointIndex == null) {
			return result;
		}
		// 设置左偏移量
		setPointTimeOffset96PointLeftValue(result, point, ymd, offsetPointNum);
		// 设置point到结果集中，这样能够保证插入的顺序
		List<String> list = result.get(ymd);
		if (list == null) {
			list = new ArrayList<String>();
		}
		list.add(point);
		result.put(ymd, list);
		// 设置右偏移量
		setPointTimeOffset96PointRightValue(result, point, ymd, offsetPointNum);
		return result;
	}

	/**
	 * 设置获取根据ymd和point左偏移结果（getPointTimeOffset96Point的结果）
	 * 
	 * @param result
	 *            ：结果集
	 * @param point
	 *            ：时刻点
	 * @param ymd
	 *            ：日期,格式（yyyyMMdd）
	 * @param offsetPointNum
	 *            :左右偏移的点数
	 */
	private static void setPointTimeOffset96PointLeftValue(Map<String, List<String>> result,
			String point, String ymd, int offsetPointNum) {
		List<String> pointList = result.get(ymd);
		if (pointList == null) {
			pointList = new LinkedList<String>();
		}
		// 若当天时刻点的个数不能满足OffsetPointNum，则往历史天推断
		boolean isCalculateOldDay = true;
		// 计算设置的时刻点数
		int count = 0;
		String[] loadPoints = SysConstant.DAY_LOAD_CURVE_96COLUMN;
		// 设置ymd当天的左时刻点
		// 是否开始进行设置
		int pointIndex = -1;
		for (int i = loadPoints.length - 1; i >= 0; i--) {
			if (loadPoints[i].equals(point)) {
				pointIndex = i;
			}
			if (i < pointIndex) {
				count++;
				pointList.add(loadPoints[i]);
			}
			// 当天的时刻点个数已经满足了偏移量的个数
			if (count >= offsetPointNum) {
				isCalculateOldDay = false;
				result.put(ymd, pointList);
				break;
			}
			if (i == 0) {
				result.put(ymd, pointList);
			}
		}
		if (isCalculateOldDay) {
			String preDay = ymd;
			while (isCalculateOldDay) {
				preDay = getPreDay(preDay, "yyyyMMdd");
				List<String> list = new LinkedList<String>();
				for (int i = loadPoints.length - 1; i >= 0; i--) {
					count++;
					list.add(loadPoints[i]);
					if (count >= offsetPointNum) {
						isCalculateOldDay = false;
						result.put(preDay, list);
						break;
					}
					// 如果该天所有点都已经设置完成，但还没有达到OffsetPointNum的个数，则设置该天的数据
					if (i == 0) {
						result.put(preDay, list);
					}
				}
			}
		}
		// 重新对时刻点进行排序，上面是倒序
		for (Entry<String, List<String>> entry : result.entrySet()) {
			List<String> list = new ArrayList<String>();
			List<String> value = entry.getValue();
			for (int i = value.size() - 1; i >= 0; i--) {
				list.add(value.get(i));
			}
			result.put(entry.getKey(), list);
		}
	}

	/**
	 * 设置获取根据ymd和point右偏移结果（getPointTimeOffset96Point的结果）
	 * 
	 * @param result
	 *            ：结果集
	 * @param point
	 *            ：时刻点
	 * @param ymd
	 *            ：日期
	 * @param offsetPointNum
	 *            :左右偏移的点数
	 */
	private static void setPointTimeOffset96PointRightValue(Map<String, List<String>> result,
			String point, String ymd, int offsetPointNum) {
		List<String> pointList = result.get(ymd);
		if (pointList == null) {
			pointList = new ArrayList<String>();
		}
		// 若当天时刻点的个数不能满足OffsetPointNum，则往历史天推断
		boolean isCalculateOldDay = true;
		// 计算设置的时刻点数
		int count = 0;
		String[] loadPoints = SysConstant.DAY_LOAD_CURVE_96COLUMN;
		// 设置ymd当天的左时刻点
		// 是否开始进行设置
		int pointIndex = loadPoints.length;
		for (int i = 0; i < loadPoints.length; i++) {
			if (loadPoints[i].equals(point)) {
				pointIndex = i;
			}
			if (i > pointIndex) {
				count++;
				pointList.add(loadPoints[i]);
			}
			// 当天的时刻点个数已经满足了偏移量的个数
			if (count >= offsetPointNum) {
				isCalculateOldDay = false;
				result.put(ymd, pointList);
				break;
			}
			if (i == loadPoints.length - 1) {
				result.put(ymd, pointList);
			}
		}
		if (!isCalculateOldDay) {
			return;
		}
		String nextDay = ymd;
		while (isCalculateOldDay) {
			nextDay = getNextDay(nextDay, "yyyyMMdd");
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < loadPoints.length; i++) {
				count++;
				list.add(loadPoints[i]);
				if (count >= offsetPointNum) {
					isCalculateOldDay = false;
					result.put(nextDay, list);
					break;
				}
				// 如果该天所有点都已经设置完成，但还没有达到OffsetPointNum的个数，则设置该天的数据
				if (i == loadPoints.length - 1) {
					result.put(nextDay, list);
				}
			}
		}
	}

	/**
	 * 获取时刻点在96点中索引
	 * 
	 * @param point
	 * @return
	 */
	private static Integer findIndexFor96Point(String point) {
		Integer index = null;
		String[] loadPoints = SysConstant.DAY_LOAD_CURVE_96COLUMN;
		for (int i = 0; i < loadPoints.length; i++) {
			if (loadPoints[i].equals(point)) {
				index = i;
				break;
			}
		}
		return index;
	}
}
