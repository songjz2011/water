package com.web.things.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

/**
 * @author songjz
 * @time 2013年7月31日
 */
public class IfTag implements BodyTag {

	private Tag parent;
	protected PageContext pageContext;
	protected BodyContent bodyContent;

	private boolean value;

	public int doStartTag() throws JspException {
		if (value) {
			System.out.println("IfTag.doStartTag() value is true");
			return EVAL_BODY_INCLUDE;
		}
		System.out.println("IfTag.doStartTag() value is false");
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public void doInitBody() throws JspException {

	}

	public int doAfterBody() throws JspException {
		return SKIP_BODY;
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	public void setParent(Tag parent) {
		this.parent = parent;
	}

	public Tag getParent() {
		return this.parent;
	}

	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent = bodyContent;
	}

	public void release() {
		bodyContent = null;
		parent = null;
	}

	/**
	 * @return the value
	 */
	public boolean isValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(boolean value) {
		this.value = value;
	}
}
