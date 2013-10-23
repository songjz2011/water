package com.thinking.java.twentyone2;

public class ResponsiveUI extends Thread {

	private static volatile double d = 1;

	public ResponsiveUI() {
		setDaemon(true);
		start();
	}

	public void run() {
		while (true) {
			d = d + (Math.PI + Math.E) / d;
		}
	}

	public static void main(String[] args) {
		new ResponsiveUI();
	}

}

class UnresponsiveUI {

	private volatile double d = 1;

	public UnresponsiveUI() throws Exception {
		while (d > 0) {
			d = d + (Math.PI + Math.E) / d;
		}
		System.in.read();
	}

}
