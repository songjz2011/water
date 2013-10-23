package com.thinking.java.twentyone2;

public class Joining {

	public static void main(String[] args) {
		Sleeper sleepy = new Sleeper("Sleepy", 1500);
		//Sleeper grumpy = new Sleeper("Grumpy", 1500);
		
		Joiner dopey = new Joiner("Dopey", sleepy);
		//Joiner doc = new Joiner("Doc", grumpy);
		
		sleepy.interrupt();
	}

}
