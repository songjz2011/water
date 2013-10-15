package com.web.things.db.driver;

/**
 * @author songjz
 * @time 2013年8月7日
 */
public class DBDriver extends DBDriverCore {

	static {
		initMethod();
	}

	public DBDriver() {
		super(DBDriver.class.getName());
	}

}
