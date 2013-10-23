package com.thinking.java.stringoperation;

public class SuperInitOrder {
	
	static {
		System.out.println("SuperInitOrder static block...");
	}

	public SuperInitOrder() {
		System.out.println("SuperInitOrder constructor...");
	}
	
	public static void main(String[] args) {
		System.out.println(InitOrder.order);
	}
	
}
