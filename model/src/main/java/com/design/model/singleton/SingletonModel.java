package com.design.model.singleton;

/**
 * <pre>
 * 单例模式
 * </pre>
 * 
 * @author songjz
 * @time 2014年6月26日
 */
public class SingletonModel {

	private static Object sigle1;

	private static Object syncRoot = new Object();

	private static Object sigle2 = new Object();

	private SingletonModel() {
	}

	/**
	 * <pre>
	 * 1、不直接synchronized(sigle1)，因为sigle1实例有没有被创建过还不知道，不能进行对它加锁
	 * 2、此种实现方式（双重锁定），不用让线程每次都加锁，只是在实例未被创建 的时候再加锁
	 * 进行两次判断是否为null，对于sigle1存在的情况的情况，就直接返回；
	 * 当sigle1为null并且同时又两个线程调用该方法时，它们将都可以通过第一重==null的判断，然后进行同步机制，这样就重复创建实例了
	 * </pre>
	 */
	public static Object getSigle1Instance() {
		if (sigle1 == null) {
			synchronized (syncRoot) {
				if (sigle1 == null) {
					sigle1 = new Object();
				}
			}
		}
		return sigle1;
	}

	/**
	 * <pre>
	 * 和getSigle1Instance的实现方式比较：
	 * 类加载时，对象就进行实例化，提前占用了系统资源而已
	 * 此种方式实现比较简单
	 * </pre>
	 */
	public static Object getSigle2Instanc() {
		return sigle2;
	}

}
