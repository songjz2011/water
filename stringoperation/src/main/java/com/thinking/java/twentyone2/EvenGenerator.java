package com.thinking.java.twentyone2;

public class EvenGenerator extends IntGenerator {

	private int currentEvenValue = 0;

	@Override
	public int next() {
		++currentEvenValue;
		++currentEvenValue;
		return currentEvenValue;
	}

	public boolean testSynchronized() {
		synchronized (this) {
			System.out.println("----");
		}
		System.out.println("wo");
		return true;
	}

	public static void main(String[] args) {
		// EvenChecker.test(new EvenGenerator());
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					new EvenGenerator().testSynchronized();
				}
			}).start();;
		}
	}

}
