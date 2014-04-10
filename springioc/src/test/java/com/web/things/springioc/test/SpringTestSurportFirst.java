package com.web.things.springioc.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.web.things.springioc.annotation.MovieAutowired;

/**
 * <pre>
 * 若是：@ContextConfiguration，则自动匹配"classpath:com/web/things/springioc/test/SpringTestSurportFirst-context.xml"
 * 
 * </pre>
 * 
 * @author songjz
 * @time 2014年4月10日
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*
 * 以下两个配置效果是一样的，不支持模糊匹配（例如：classpath:spring-context*.xml）
 */
// @ContextConfiguration(locations = "classpath:spring-context-annotation.xml")
@ContextConfiguration({ "/spring-context-annotation.xml" })
// defaults to "file:src/main/webapp"
// @WebAppConfiguration
// 定义 启动的环境，分为（dev:开发环境，test:测试环境，production:生产环境），一般用于连接数据库
// @ActiveProfiles("dev")
public class SpringTestSurportFirst {

	@Resource
	private MovieAutowired movieAutowired;

	@Test
	public void test() {
		System.out.println("------------" + movieAutowired);
	}

}
