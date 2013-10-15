package com.web.things.db.driver.connection;

import com.web.things.db.driver.monitor.manager.IDBDriverFactory;


/**
 * @author songjz
 * @time 2013年8月7日
 */
public class DBDriverBase {

	protected IDBDriverFactory factory;

	/**
	 * @return the factory
	 */
	public IDBDriverFactory getFactory() {
		return factory;
	}

	/**
	 * @param factory
	 *            the factory to set
	 */
	public void setFactory(IDBDriverFactory factory) {
		this.factory = factory;
	}
}
