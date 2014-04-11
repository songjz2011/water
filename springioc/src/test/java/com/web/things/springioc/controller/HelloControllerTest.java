package com.web.things.springioc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations = { "classpath:spring-context-annotation.xml",
		"classpath:spring-mvc.xml" })
public class HelloControllerTest {

	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void before() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void hello_test() {
		try {
			MockHttpServletRequestBuilder builder = get("/hello");
			ResultActions actions = mockMvc.perform(builder);
			actions.andExpect(status().isOk());
			actions.andExpect(forwardedUrl("/page/hello.jsp"));
			actions.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
