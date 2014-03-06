package com.design.model.memorandum;

/**
 * <pre>
 * 发起人
 * </pre>
 * 
 * @author songjz
 * @time 2014年3月4日
 */
public class Originator {

	/**
	 * 状态
	 */
	private String state;

	/**
	 * 创造备忘录（将当前保存的数据信息，导入进新的备忘录中，用于恢复原先的数据）
	 * 
	 * @return
	 */
	public Memento createMemento() {
		return new Memento(state);
	}

	/**
	 * 需要保存的备忘录
	 * 
	 * @param memento
	 */
	public void setMemento(Memento memento) {
		this.state = memento.getState();
	}

	/**
	 * 显示 保存的 备忘录中的数据
	 */
	public void showMemento() {
		System.out.println("备忘录保存的数据：" + this.state);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
