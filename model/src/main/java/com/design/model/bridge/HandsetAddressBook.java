package com.design.model.bridge;

/**
 * <pre>
 * 桥接模式 - 手机软件 - 通讯录
 * </pre>
 * 
 * @author songjz
 * @time 2014年6月27日
 */
public class HandsetAddressBook implements HandsetSoft {

	public void run() {
		System.out.println("运行手机通讯录");
	}

}
