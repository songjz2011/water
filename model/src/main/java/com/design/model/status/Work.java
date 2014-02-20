package com.design.model.status;

public class Work {
	/**
	 * 当前状态
	 */
	private State currentState;

	/**
	 * 时间
	 */
	private double hour;

	/**
	 * 任务是否完成
	 */
	private boolean taskFinished;

	public Work() {

	}

	/**
	 * 执行状态
	 */
	public void writeProgram() {
		if(currentState == null) {
			return;
		}
		currentState.writeProgram(this);
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public double getHour() {
		return hour;
	}

	public void setHour(double hour) {
		this.hour = hour;
	}

	public boolean isTaskFinished() {
		return taskFinished;
	}

	public void setTaskFinished(boolean taskFinished) {
		this.taskFinished = taskFinished;
	}

}
