package com.design.model.proxy;

/**
 * <pre>
 * 追求者
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月11日
 */
public class Pursuit implements ISendGift {

	private Girl girl;

	public Pursuit(Girl girl) {
		this.girl = girl;
	}

	public void sendFlower() {
		System.out.println("送给 " + girl.getName() + " 鲜花");
	}

	public void sendChocolate() {
		System.out.println("送给 " + girl.getName() + " 巧克力");
	}
}
