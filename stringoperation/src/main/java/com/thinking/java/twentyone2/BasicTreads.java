package com.thinking.java.twentyone2;

public class BasicTreads {

	public static void main(String[] args) {
		Thread t = new Thread(new LiftOff());
		t.start();
	}

}
