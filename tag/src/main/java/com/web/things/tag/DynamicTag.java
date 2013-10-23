package com.web.things.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * DynamicAttributes只能和SimpleTagSupport绑定使用
 * 
 * @author songjz
 * @time 2013年7月31日
 */
public class DynamicTag extends SimpleTagSupport implements DynamicAttributes {

	// 用来接收动态属性
	private List<Object> keys = new ArrayList<Object>();
	private List<Object> values = new ArrayList<Object>();

	private String name;

	public void setDynamicAttribute(String uri, String name, Object value) throws JspException {
		keys.add(name);
		values.add(value);
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println(this);
		System.out.println(keys);
		JspContext ctx = getJspContext();
		JspWriter out = ctx.getOut();
		float num = 0;
		float sum = Float.parseFloat((String) values.get(0));
		out.print(sum);
		for (int i = 1; i < keys.size(); i++) {
			String temp = (String) values.get(i);
			num = Float.parseFloat(temp);
			sum = sum + num;
			out.print(" + " + num);
		}
		out.print(" = " + sum);
		ctx.setAttribute("sum", Float.toString(sum));
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
