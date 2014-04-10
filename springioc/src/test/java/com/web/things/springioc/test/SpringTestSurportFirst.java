package com.web.things.springioc.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.web.things.springioc.annotation.MovieAutowired;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-annotation.xml")
public class SpringTestSurportFirst {

	@Resource
	private MovieAutowired movieAutowired;

	@Test
	public void test() {
		System.out.println(movieAutowired);
	}

}
