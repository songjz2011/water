package com.thinking.java.ninetin4;

public enum SecurityCategory {
	STOCK(Stock.class), BOND(Bond.class);

	Security[] values;

	private SecurityCategory(Class<? extends Security> kind) {
		this.values = kind.getEnumConstants();
	}

	public static void main(String[] args) {
		System.out.println(SecurityCategory.BOND.name());
	}

}
