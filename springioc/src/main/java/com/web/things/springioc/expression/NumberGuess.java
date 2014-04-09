package com.web.things.springioc.expression;

import org.springframework.beans.factory.annotation.Value;

public class NumberGuess {

	private Double randomNumber;

	private String defaultLocale;

	@Value("我是谁")
	private String name;

	@Value("#{ systemProperties['java.version'] }")
	private String address;

	public Double getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(Double randomNumber) {
		this.randomNumber = randomNumber;
	}

	public String getDefaultLocale() {
		return defaultLocale;
	}

	public void setDefaultLocale(String defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
