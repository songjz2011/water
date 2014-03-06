package com.design.model.memorandum;

/**
 * <pre>
 * 备忘录
 * </pre>
 * 
 * @author songjz
 * @time 2014年3月4日
 */
public class Memento {

	/** 备忘录的数据 */
	private String state;

	/**
	 * 构造备忘录，初始化相关数据
	 * 
	 * @param state
	 */
	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

}
