package com.design.model.status;

/**
 * <pre>
 * 加班太晚，在办公室休息
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月20日
 */
public class SleepingState implements State {

	public void writeProgram(Work work) {
		System.out.println("当前时间：" + work.getHour() + "点 ，不行了，睡着了");
	}

}
