package com.design.model.responsibility;

/**
 * <pre>
 * 职责链模式 - 处理 抽象对象
 * </pre>
 * 
 * @author songjz
 * @time 2014年7月3日
 */
public abstract class Handler {

	protected Handler nextHandler;

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public abstract void handleRequest(int request);

}
