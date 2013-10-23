package com.web.things.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * @author songjz
 * @time 2013年7月30日
 */
public class HelloTag implements Tag {

	private PageContext pageContext;

	private Tag parent;

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

	public int doStartTag() throws JspException {
		// 返回SKIP_BODY，表示不计算标签体
		return EVAL_BODY_INCLUDE;
	}

	/**
	 * 结束标签时的操作，<br>
	 * EVAL_PAGE：表示容器将在标签结束时继续计算JSP页面的其他部分
	 * SKIP_PAGE：表示容器将在标签结束时不继续计算JSP页面的其他部分，定义在该标签之后的内容不会被显示
	 */

	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().write("Hello World!你好，世界！");
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspTagException(e);
		}
		return EVAL_PAGE;
	}

	public Tag getParent() {
		return parent;
	}

	public void release() {

	}

	/**
	 * 设置标签的页面的上下文
	 */

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	/**
	 * 设置上一级标签
	 */

	public void setParent(Tag parent) {
		this.parent = parent;
	}

}
