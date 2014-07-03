package com.design.model.bridge;

/**
 * <pre>
 * 桥接模式 - 手机品牌 -- M
 * </pre>
 * 
 * @author songjz
 * @time 2014年6月30日
 */
public class HandsetBrandM extends HandsetBrand {

	public void run() {
		this.soft.run();
	}

}
