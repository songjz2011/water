package com.design.model.observer;

/**
 * <pre>
 * 通知者接口
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月14日
 */
public interface Subject {

	/**
	 * 增加观察者对象
	 */
	void attach(Observer observer);

	/**
	 * 移除观察值对象
	 */
	void detach(Observer observer);

	/**
	 * 通知
	 */
	void notice();

	/**
	 * 获取通知者状态
	 */
	String getAction();

	void setAction(String action);
}
