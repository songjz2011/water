package com.design.model.bridge;

/**
 * <pre>
 * 桥接模式 - 手机软件 - 手机游戏
 * </pre>
 * 
 * @author songjz
 * @time 2014年6月27日
 */
public class HandsetGame implements HandsetSoft {

	public void run() {
		System.out.println("运行手机游戏");
	}

}
