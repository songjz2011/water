package com.design.model.status;

/**
 * <pre>
 * 上午12点之前的状态
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月20日
 */
public class ForenoonState implements State {

	public void writeProgram(Work work) {
		if (work.getHour() < 12) {
			System.out.println("当前时间：" + work.getHour() + "点 上午工作，精神百倍");
			return;
		}
		work.setCurrentState(new NoonState());
		work.writeProgram();
	}

}
