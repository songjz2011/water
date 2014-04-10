package com.web.things.webcms.spring.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring*.xml" })
@WebAppConfiguration
//@TransactionConfiguration(defaultRollback = true, transactionManager = "")
@Transactional
public class SpringTestFirst {

	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		System.out.println("@Before");
		// webAppContextSetup 注意上面的static import
		// webAppContextSetup 构造的WEB容器可以添加fileter 但是不能添加listenCLASS
		// WebApplicationContext context =
		// ContextLoader.getCurrentWebApplicationContext();
		// 如果控制器包含如上方法 则会报空指针
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@BeforeTransaction
	public void beforeTransaction() {
		System.out.println("beforeTransaction()");
	}

	@Test
	public void test() {
		try {
			System.out.println("test()");
			mockMvc.perform((get("/spring-demo/helloworld"))).andExpect(status().isOk())
					.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
