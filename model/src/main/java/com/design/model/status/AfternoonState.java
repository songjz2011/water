package com.design.model.status;

/**
 * <pre>
 * 下午的工作状态
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月20日
 */
public class AfternoonState implements State {

	public void writeProgram(Work work) {
		if (work.getHour() < 17) {
			System.out.println("当前时间：" + work.getHour() + "点  下午状态还不错，继续努力");
			return;
		}
		work.setCurrentState(new EveningState());
		work.writeProgram();
	}

}
