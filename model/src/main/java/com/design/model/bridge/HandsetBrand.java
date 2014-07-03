package com.design.model.bridge;

/**
 * <pre>
 * 桥接模式 - 手机品牌
 * </pre>
 * 
 * @author songjz
 * @time 2014年6月27日
 */
public abstract class HandsetBrand {

	protected HandsetSoft soft;

	public HandsetBrand() {

	}

	public void setHandsetSoft(HandsetSoft soft) {
		this.soft = soft;
	}

	public abstract void run();

}
