package com.web.things.tag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

/**
 * @author songjz
 * @time 2013年7月30日
 */
public class HelloBodyTag implements BodyTag {
	private Tag parent;
	protected PageContext pageContext;
	protected BodyContent bodyContent;

	private int counts;

	/**
	 * <pre>
	 * 开始标签时的操作，<br>
	 * EVAL_BODY_INCLUDE：指出jsp引擎计算标记体并输出<br>
	 * SKIP_BODY：指出jsp引擎跳过标记体且不输出<br>
	 * 标签体：
	 * 1、tld文件中定义的 bodycontent
	 * 2、在doStartTag()方法中的返回EVAL_BODY_INCLUDE、SKIP_BODY对标签体是否起作用，
	 * 		只有在定义了标签体，并且实现BodyTag接口时，才起作用
	 * </pre>
	 */

	public int doStartTag() throws JspException {
		System.out.println("HellorBodyTag.doStartTag()");
		if (counts < 1) {
			return SKIP_BODY;
		}
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		System.out.println("HellorBodyTag.doEndTag()");
		try {
			if (bodyContent != null) {
				bodyContent.writeOut(bodyContent.getEnclosingWriter());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new JspTagException(e);
		}
		return EVAL_PAGE;
	}

	/**
	 * 如果在计算BodyContent时需要进行一些初始化，就在这个方法中进行。
	 */

	public void doInitBody() throws JspException {
		System.out.println("HellorBodyTag.doInitBody()");
	}

	/**
	 * <pre>
	 * 每次计算完BodyTag后调用doAfterBody，
	 * 如果返回EVAL_BODY_TAG：(As of Java JSP API 1.2, use BodyTag.EVAL_BODY_BUFFERED or
	 * IterationTag.EVAL_BODY_AGAIN)，表示继续计算一次BodyTag，
	 * 直接返回SKIP_BODY：才继续执行doEndTag方法
	 * </pre>
	 */

	public int doAfterBody() throws JspException {
		System.out.println("HellorBodyTag.doAfterBody()");
		try {
			String dateString = new Date().toString();
			pageContext.getOut().write("Hello World hellking.现在的时间是：" + dateString + "<br>");
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspTagException("Fatal error:hello tag conld not write to JSP out");
		}
		if (counts > 1) {
			counts--;
			return EVAL_BODY_BUFFERED;
		}
		return SKIP_BODY;
	}

	public void release() {

	}

	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent = bodyContent;
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	public void setParent(Tag parent) {
		this.parent = parent;
	}

	public Tag getParent() {
		return parent;
	}

	/**
	 * @return the counts
	 */
	public int getCounts() {
		return counts;
	}

	/**
	 * @param counts
	 *            the counts to set
	 */
	public void setCounts(int counts) {
		this.counts = counts;
	}

}
