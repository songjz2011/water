package com.thinking.java.reflect;

public class Bird extends Animal {

	private int birdId;

	protected String birdName;

	public String birdDiscribe;

	private void printPrivateBird() {
		System.out.println("printPrivateBird...");
	}

	protected void printProtectedBird() {
		System.out.println("printProtectedBird...");
	}

	public int getBirdId() {
		return birdId;
	}

	public void setBirdId(int birdId) {
		this.birdId = birdId;
	}

	public String getBirdName() {
		return birdName;
	}

	public void setBirdName(String birdName) {
		this.birdName = birdName;
	}

	public String getBirdDiscribe() {
		return birdDiscribe;
	}

	public void setBirdDiscribe(String birdDiscribe) {
		this.birdDiscribe = birdDiscribe;
	}

}
