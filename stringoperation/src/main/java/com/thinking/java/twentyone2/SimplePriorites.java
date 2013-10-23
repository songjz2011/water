package com.thinking.java.twentyone2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimplePriorites implements Runnable {

	private int countDown = 5;

	private volatile static double d;

	private int priority;

	public SimplePriorites(int priority) {
		this.priority = priority;
	}

	public String toString() {
		return Thread.currentThread() + ", priority= " + priority
				+ ", countdown= " + countDown;
	}

	public void run() {
		Thread.currentThread().setPriority(priority);
		while (true) {
			for (int i = 1; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double) i;
				if (i % 100 == 0) {
					Thread.yield();
				}
			}
			System.out.println(this);
			if (--countDown == 0) {
				return;
			}
		}
	}
	
	public void printD() {
		System.out.println("d=" + d);
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new SimplePriorites(Thread.MIN_PRIORITY));
		}
		exec.execute(new SimplePriorites(Thread.MAX_PRIORITY));
		exec.shutdown();
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
