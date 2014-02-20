package com.design.model.observer;


/**
 * <pre>
 * 股票的观察值
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月11日
 */
public class GameObserver extends Observer {

	public GameObserver(String name, Subject subject) {
		super(name, subject);
	}

	public void update() {
		StringBuilder log = new StringBuilder();
		log.append(subject.getAction());
		log.append(" ").append(name);
		log.append(" 暂停游戏，继续工作!");
		System.out.println(log);
	}
}
