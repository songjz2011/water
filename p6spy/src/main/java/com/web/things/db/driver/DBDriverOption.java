package com.web.things.db.driver;

/**
 * @author songjz
 * @time 2013年8月6日
 */
public class DBDriverOption {
	/**
	 * 数据库驱动
	 */
	private String driverName;

	private String monitor;

	private String factory;

	/**
	 * 
	 */
	private String deregisterDrivers;

	/**
	 * @return the monitor
	 */
	public String getMonitor() {
		return monitor;
	}

	/**
	 * @param monitor
	 *            the monitor to set
	 */
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}

	/**
	 * @param driverName
	 *            the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/**
	 * @return the factory
	 */
	public String getFactory() {
		return factory;
	}

	/**
	 * @param factory
	 *            the factory to set
	 */
	public void setFactory(String factory) {
		this.factory = factory;
	}

	/**
	 * @return the deregisterDrivers
	 */
	public String getDeregisterDrivers() {
		return deregisterDrivers;
	}

	/**
	 * @param deregisterDrivers
	 *            the deregisterDrivers to set
	 */
	public void setDeregisterDrivers(String deregisterDrivers) {
		this.deregisterDrivers = deregisterDrivers;
	}

}
