package com.web.things.tag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author songjz
 * @time 2013年7月30日
 */
public class HelloSupportTag extends TagSupport {

	private static final long serialVersionUID = 713004454014686835L;

	/**
	 * <pre>
	 * 开始标签时的操作，<br>
	 * EVAL_BODY_INCLUDE：指出jsp引擎计算标记体并输出<br>
	 * SKIP_BODY：指出jsp引擎跳过标记体且不输出<br>
	 * 标签体：
	 * 1、tld文件中定义的 bodycontent
	 * 2、在doStartTag()方法中的返回EVAL_BODY_INCLUDE、SKIP_BODY对标签体是否起作用，
	 * 		只有在定义了标签体，并且实现BodyTag接口时，才起作用
	 * 3、参见HelloBodyTag
	 * </pre>
	 */
	@Override
	public int doStartTag() throws JspException {
		System.out.println("HelloSupportTage.doStartTag()");
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		String dateString = new Date().toString();
		try {
			pageContext.getOut().write("Hello World hellking.<br>现在的时间是：" + dateString);
		} catch (IOException ex) {
			throw new JspTagException("Fatal error:hello tag conld not write to JSP out");
		}
		return EVAL_PAGE;
	}

}
