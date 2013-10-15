package com.web.things.springioc;

import java.beans.ConstructorProperties;

/**
 * @author songjz
 * @time 2013年10月12日
 */
public class ExampleBean1 {

	// No. of years to the calculate the Ultimate Answer
	private int years;

	// The Answer to Life, the Universe, and Everything
	private String ultimateAnswer;

	@ConstructorProperties({ "id", "name" })
	public ExampleBean1(int years, String ultimateAnswer) {
		this.years = years;
		this.ultimateAnswer = ultimateAnswer;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public String getUltimateAnswer() {
		return ultimateAnswer;
	}

	public void setUltimateAnswer(String ultimateAnswer) {
		this.ultimateAnswer = ultimateAnswer;
	}

}
