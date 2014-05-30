package com.web.things.springioc.transaction.aop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <pre>
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2014年5月30日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context-annotation.xml",
		"classpath:db-aop.xml" })
@ActiveProfiles("test")
public class DefaultFooServiceTest {

	@Resource(name = "defaultFooService")
	private FooService service;

	@Test
	public void test() {
		System.out.println(service);
	}

}
