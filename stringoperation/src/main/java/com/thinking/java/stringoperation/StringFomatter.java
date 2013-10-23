package com.thinking.java.stringoperation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class StringFomatter {

	public static void main(String[] args) throws ParseException {
		Formatter f = new Formatter(System.out);
		char u = 'a';
		System.out.println("u = 'a'");
		f.format("s: %%s\n", u);
		//f.format("d: %d\n", u);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		Date date = dateFormat.parse("201301");
		dateFormat.applyPattern("yyyy-MM");
		System.out.println(dateFormat.format(date));
	}
	
}
