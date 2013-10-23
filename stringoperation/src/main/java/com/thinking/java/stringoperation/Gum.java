package com.thinking.java.stringoperation;

public class Gum {
	
	public Gum(String name) {
		
	}

	public void hello() {
		System.out.println("Hello Gum...");
	}
	
	public static void main(String[] args) {
		try {
			Class.forName("com.thinking.java.stringoperation.Gum").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
