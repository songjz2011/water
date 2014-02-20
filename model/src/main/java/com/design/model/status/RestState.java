package com.design.model.status;

/**
 * <pre>
 * 休息状态
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月20日
 */
public class RestState implements State {

	public void writeProgram(Work work) {
		System.out.println("当前时间：" + work.getHour() + "点 ，工作完成， 下班回家");
	}

}
