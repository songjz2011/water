package com.design.model.status;

/**
 * <pre>
 * 抽象状态
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月20日
 */
public interface State {

	/**
	 * 执行状态任务
	 * 
	 * @param work
	 */
	void writeProgram(Work work);

}
