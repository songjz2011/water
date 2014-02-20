package com.design.model.status;

/**
 * <pre>
 * 中午的工作状态
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月20日
 */
public class NoonState implements State {

	public void writeProgram(Work work) {
		if (work.getHour() < 13) {
			System.out.println("当前时间：" + work.getHour() + "点  饿了，午饭；犯困，午休");
			return;
		}
		work.setCurrentState(new AfternoonState());
		work.writeProgram();
	}

}
