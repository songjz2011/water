package com.design.model.prototype;

import org.junit.Test;

public class ResumeTest {

	@Test
	public void test() {
		Resume resume = new Resume("大牛");
		resume.setPersonalInfo("男", "29");
		resume.setWorkExprience("2010-2013", "XX公司");
		resume.display();
		
		Resume resume1 = resume.clone();
		resume1.display();
		
		resume1.setWorkExprience("2015-2018", "YY公司");
		
		resume.display();
		resume1.display();
		
	}
}
