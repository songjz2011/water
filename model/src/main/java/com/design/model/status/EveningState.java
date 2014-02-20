package com.design.model.status;

/**
 * <pre>
 * 晚上工作状态
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月20日
 */
public class EveningState implements State {

	public void writeProgram(Work work) {
		if (work.isTaskFinished()) {
			work.setCurrentState(new RestState());
			work.writeProgram();
			return;
		}
		if (work.getHour() < 21) {
			System.out.println("当前时间：" + work.getHour() + "点 ，加班哦，疲惫至极");
			return;
		}
		work.setCurrentState(new SleepingState());
		work.writeProgram();
	}

}
