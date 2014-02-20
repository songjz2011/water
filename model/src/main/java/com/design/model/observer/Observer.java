package com.design.model.observer;

/**
 * <pre>
 * 抽象 观察者
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月14日
 */
public abstract class Observer {

	protected String name;

	protected Subject subject;

	public Observer(String name, Subject subject) {
		this.name = name;
		this.subject = subject;
	}

	public abstract void update();

}
