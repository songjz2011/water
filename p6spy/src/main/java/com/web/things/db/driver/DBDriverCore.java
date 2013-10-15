package com.web.things.db.driver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import com.web.things.db.driver.monitor.manager.IDBDriverFactory;
import com.web.things.db.driver.util.DBDriverProperties;
import com.web.things.db.driver.util.DBDriverUtil;
import com.web.things.util.StringUtil;

/**
 * @author songjz
 * @time 2013年8月6日
 */
public class DBDriverCore implements Driver {

	/**
	 * 实际的链接数据库的驱动
	 */
	protected Driver realDriver = null;

	/**
	 * 是否已经初始化
	 */
	protected static boolean initialized = false;

	/**
	 * 参数
	 */
	protected static DBDriverOption dbDriverOption;

	/**
	 * 封装的工厂，利用此工厂进行监控操作
	 */
	protected static IDBDriverFactory factory;

	public DBDriverCore(String name) {

	}

	/**
	 * 初始化
	 * 
	 * @param spydriver
	 */
	public synchronized static void initMethod() {
		if (initialized) {
			return;
		}
		try {
			DBDriverProperties.init();
			dbDriverOption = DBDriverProperties.getDbDriverOption();
			initFactory();
			registerDriver();
			initialized = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private static void initFactory() {
		String factoryName = dbDriverOption.getFactory();
		try {
			if (!StringUtil.isEmpty(factoryName)) {
				factory = (IDBDriverFactory) DBDriverUtil.forName(factoryName).newInstance();
			}
		} catch (Exception e) {
		}
	}

	private static void registerDriver() throws Exception {
		String driverName = dbDriverOption.getDriverName();
		DBDriver dbDriver = null;
		if (factory != null) {
			dbDriver = new DBDriver();
			DriverManager.registerDriver(dbDriver);
		}
		boolean deregisterDrivers = StringUtil.isTrue(dbDriverOption.getDeregisterDrivers());
		if (deregisterDrivers) {
			deregister(driverName);
		}
		Driver driver = (Driver) DBDriverUtil.forName(driverName).newInstance();
		if (deregisterDrivers) {
			DriverManager.registerDriver(driver);
		}
		if(dbDriver != null) {
			dbDriver.setRealDriver(driver);
		}
	}

	private static void deregister(String className) throws SQLException {
		List<Driver> dereg = new ArrayList<Driver>();
		for (Enumeration<Driver> e = DriverManager.getDrivers(); e.hasMoreElements();) {
			Driver driver = (Driver) e.nextElement();
			if (driver instanceof DBDriver) {
				break;
			}
			if (driver.getClass().getName().equals(className)) {
				dereg.add(driver);
			}
		}
		for (Driver driver : dereg) {
			DriverManager.deregisterDriver(driver);
		}
	}

	/**
	 * @param realDriver
	 *            the realDriver to set
	 */
	public void setRealDriver(Driver realDriver) {
		this.realDriver = realDriver;
	}

	public static Connection wrapConnection(Connection conn) throws SQLException {
		if (factory != null) {
			Connection wrapConnect = factory.getConnection(conn);
			if (wrapConnect != null) {
				return wrapConnect;
			}
		}
		return conn;
	}

	public Connection connect(String url, Properties info) throws SQLException {
		Connection conn = realDriver.connect(url, info);
		return wrapConnection(conn);
	}

	public boolean acceptsURL(String url) throws SQLException {
		return realDriver.acceptsURL(url);
	}

	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		return realDriver.getPropertyInfo(url, info);
	}

	public int getMajorVersion() {
		return realDriver.getMajorVersion();
	}

	public int getMinorVersion() {
		return realDriver.getMinorVersion();
	}

	public boolean jdbcCompliant() {
		return realDriver.jdbcCompliant();
	}
}
