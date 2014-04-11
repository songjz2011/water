package com.web.things.springioc.transaction;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context-annotation.xml",
		"classpath:spring-context-db.xml", "classpath:spring-mvc.xml" })
@WebAppConfiguration(value = "src/main/webapp")
//定义 启动的环境，分为（dev:开发环境，test:测试环境，production:生产环境），一般用于连接数据库
@ActiveProfiles("test")
public class SpringJdbcTest {
	
	@Resource(name="dataSource1")
	private DriverManagerDataSource dataSource1;
	
	@Resource(name = "dataSource2")
	private BasicDataSource dataSource2;
	
	@Resource(name="dataSource3")
	private ComboPooledDataSource dataSource3;

	@Test
	public void test() {
		System.out.println("----" + dataSource1);
		System.out.println("----" + dataSource2);
		System.out.println("----" + dataSource3);
	}
	
}
