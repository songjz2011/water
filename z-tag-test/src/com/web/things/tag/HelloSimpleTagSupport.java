package com.web.things.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 每次遇到标签，容器构造一个SimpleTag的实例，这个构造方法没有参数。<br>
 * 和红典的标签一样，SimpleTag不能缓冲，故不能重用，每次都需要构造新的实例 。<br>
 * setJspContext()、setParent(): 只有这个标签在另一个标签之内时，才调用setParent()方法。<br>
 * doTag(): 所有标签的逻辑、迭代和Body计算，都在这个方法中<br>
 * 
 * @author songjz
 * @time 2013年7月31日
 */
public class HelloSimpleTagSupport extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		getJspContext()
				.getOut()
				.write("<table border=1><tr bgcolor=9944cc><td>simpeltag测试</tr></td><tr tr=cc44cc><td>helloWorld!</td></tr></table>");
	}

}
