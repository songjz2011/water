package com.design.model.factory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <pre>
 * 加法-计算操作
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月3日
 */
public class OperateAdd extends Operate {

	public double getResult() {
		return numberA + numberB;
	}
	
	public static void main(String[] args) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String ymd = "20130120";
			Date date = format.parse(ymd);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			System.out.println(String.valueOf(calendar.get(Calendar.MONTH) + 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
