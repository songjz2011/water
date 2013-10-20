package com.web.things.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * @author songjz
 * @time 2013年7月31日
 */
public class OutTag implements Tag {

	private PageContext pageContext;

	private Tag parent;

	private Object value;

	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().write(value.toString());
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspTagException("Fatal error:hello tag conld not write to JSP out");
		}
		return EVAL_PAGE;
	}

	@Override
	public void release() {
		parent = null;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	@Override
	public void setParent(Tag parent) {
		this.parent = parent;
	}

	@Override
	public Tag getParent() {
		return parent;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

}
