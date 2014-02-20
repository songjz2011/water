package com.design.model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 秘书 - 通知者对象
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月11日
 */
public class SecretarySuject implements Subject {

	private List<Observer> observers = new ArrayList<Observer>();

	private String action;

	/**
	 * 增加观察者对象
	 */
	public void attach(Observer observer) {
		observers.add(observer);
	}

	/**
	 * 移除观察者对象
	 */
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	/**
	 * 通知
	 */
	public void notice() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
