package com.design.model.proxy;

public class PursuitProxy implements ISendGift {

	private Pursuit pursuit;

	public PursuitProxy(Girl girl) {
		this.pursuit = new Pursuit(girl);
	}

	public void sendFlower() {
		pursuit.sendFlower();
	}

	public void sendChocolate() {
		pursuit.sendChocolate();
	}

	public static void main(String[] args) {
		Girl girl = new Girl();
		girl.setName("小乔");

		PursuitProxy proxy = new PursuitProxy(girl);
		proxy.sendChocolate();
		proxy.sendFlower();
	}
}
