package com.web.things.webcms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * spring mvc controller demo
 * </pre>
 * 
 * @author songjz
 * @time 2014年3月24日
 */
@Controller
@RequestMapping(value = "/spring-demo")
public class ControllerDemo {

	@RequestMapping(value = "/helloworld")
	public String demo(HttpServletRequest request) {
		request.setAttribute("name", "汤姆");
		return "demo/spring/helloworld";
	}
}
