package com.web.things.spring.scope.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.things.springioc.ObjectContainerInitCallbacks;
import com.web.things.springioc.factory.SpringFactory;

/**
 * <pre>
 * 用户登陆controller
 * </pre>
 * 
 * @author songjz
 * @time 2013年10月23日
 */
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -7784283605386204171L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectContainerInitCallbacks bean = SpringFactory.getBean("objectContainerInitCallbacks",
				ObjectContainerInitCallbacks.class);
		System.out.println("欧 = " + bean);
		response.sendRedirect("login.jsp");
	}

}
