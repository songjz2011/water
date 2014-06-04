package com.web.things.springioc.transaction.aop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.web.things.springioc.factory.SpringFactoryDbByAop;

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

	@Test
	public void test1() {
		System.setProperty("spring.profiles.active", "test");
		//FooService s = SpringFactoryDbByAop.getBeanByDefaultId(FooService.class);
		FooService s = SpringFactoryDbByAop.getBean("defaultFooService", FooService.class);
//		 FooService s =
//		 (FooService)SpringFactoryDbByAop.getBean("fooService");
		System.out.println(s);
	}

	@Test
	public void test2() {
		System.out.println("-----------" + System.getProperty("spring.profiles.active"));
	}

}
