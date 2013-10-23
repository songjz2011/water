package com.thinking.java.stringoperation;

import java.util.Random;

public class InitOrder extends SuperInitOrder{

	public static int order = 1;
	
	private static Random random = new Random();
	
	public static int randomValue = random.nextInt(1000);

	static {
		System.out.println("InitOrder static block...");
	}

	public InitOrder() {
		System.out.println("InitOrder constructor...");
	}

	public static void main(String[] args) {
		InitOrder.order = 2;
		InitOrder order = new InitOrder();
		System.out.println(InitOrder.order);
	}
}
