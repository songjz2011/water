package com.web.things.tag.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author songjz
 * @time 2013年8月1日
 */
public class HelloController extends HttpServlet {

	private static final long serialVersionUID = 8259197729202563123L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("username = " + getInitParameter("username"));
		System.out.println(this);
		request.getRequestDispatcher("").forward(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("destroy()...");
		super.destroy();
	}

	@Override
	public String getInitParameter(String name) {
		return super.getInitParameter(name);
	}

	@Override
	@SuppressWarnings({"rawtypes" })
	public Enumeration getInitParameterNames() {
		return super.getInitParameterNames();
	}

	@Override
	public ServletConfig getServletConfig() {
		return super.getServletConfig();
	}

	@Override
	public ServletContext getServletContext() {
		return super.getServletContext();
	}

	@Override
	public String getServletInfo() {
		return super.getServletInfo();
	}

	@Override
	public String getServletName() {
		return super.getServletName();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init()...");
		super.init();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig config)...");
		super.init(config);
	}

}
