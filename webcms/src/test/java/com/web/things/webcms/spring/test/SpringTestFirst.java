package com.web.things.webcms.spring.test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml","classpath:spring-mvc.xml"})
//@ContextConfiguration({ "classpath:spring*.xml" })

//@ContextHierarchy({
//    @ContextConfiguration(name = "parent",locations={"classpath:spring-context.xml"}),
//    @ContextConfiguration(name = "child",locations={"classpath:spring-mvc.xml"})
//})

//defaults to "file:src/main/webapp"
@WebAppConfiguration("src/main/webapp")

//@TransactionConfiguration(defaultRollback = true, transactionManager = "")
//@Transactional

//定义 启动的环境，分为（dev:开发环境，test:测试环境，production:生产环境）
//@ActiveProfiles("dev")
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
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		//this.mockMvc = MockMvcBuilders.standaloneSetup(new ControllerDemo()).build();
	}

	@BeforeTransaction
	public void beforeTransaction() {
		System.out.println("beforeTransaction()");
	}

	@Test
	public void testHello() {
		try {
			System.out.println("testHello()");
			MockHttpServletRequestBuilder builder = get("/spring-demo/helloworld");
			ResultActions actions = mockMvc.perform(builder);
			actions.andExpect(status().isOk());
			actions.andExpect(forwardedUrl("/page/demo/spring/helloworld.jsp"));
			assertEquals("汤姆",actions.andReturn().getRequest().getAttribute("name"));
			actions.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testJson() {
		try {
			System.out.println("testJson()");
			MockHttpServletRequestBuilder builder = post("/spring-demo/json");
			ResultActions actions = mockMvc.perform(builder);
			actions.andExpect(status().isOk());
			actions.andExpect(content().contentType("text/plain;charset=UTF-8"));
			System.out.println(actions.andReturn().getResponse().getContentAsString());
			actions.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
