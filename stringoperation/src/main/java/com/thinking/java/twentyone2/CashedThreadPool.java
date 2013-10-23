package com.thinking.java.twentyone2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CashedThreadPool {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0; i<5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
		System.out.println("Waiting for LiftOff");
	}

}
