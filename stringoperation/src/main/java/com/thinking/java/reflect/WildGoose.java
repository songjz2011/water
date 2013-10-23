package com.thinking.java.reflect;

public class WildGoose extends Bird {

	private String wildGooseColor;

	protected String wildGooseAddress;

	public String wildGooseNumber;
	
	private void printPrivateWildGoose() {
		System.out.println("printPrivateWildGoose...");
	}

	protected void printProtectedWildGoose() {
		System.out.println("printProtectedWildGoose...");
	}

	public String getWildGooseColor() {
		return wildGooseColor;
	}

	public void setWildGooseColor(String wildGooseColor) {
		this.wildGooseColor = wildGooseColor;
	}

	public String getWildGooseAddress() {
		return wildGooseAddress;
	}

	public void setWildGooseAddress(String wildGooseAddress) {
		this.wildGooseAddress = wildGooseAddress;
	}

	public String getWildGooseNumber() {
		return wildGooseNumber;
	}

	public void setWildGooseNumber(String wildGooseNumber) {
		this.wildGooseNumber = wildGooseNumber;
	}

}
