package com.thinking.java.ninetin4;

public enum Stock implements Security {
	SHORT, LOND, MARGIN;

	public void hello() {
		System.out.println(Stock.class.getName());
	}
}
