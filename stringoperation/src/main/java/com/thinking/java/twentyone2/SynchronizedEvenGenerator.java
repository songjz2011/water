package com.thinking.java.twentyone2;

public class SynchronizedEvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;

	@Override
	public synchronized int next() {
		++currentEvenValue;
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}

}
