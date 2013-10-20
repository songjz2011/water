package com.web.things.tag;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

/**
 * @author songjz
 * @time 2013年7月31日
 */
public class ForEachTag implements BodyTag {
	private Tag parent;
	protected PageContext pageContext;
	protected BodyContent bodyContent;
	/** Tag的属性 */
	private String name;
	/** 为要迭代的对象 */
	private Iterator<Object> it;
	/** 表示it中对象的类型 */
	private String type;

	/**
	 * 设置属性collection
	 */
	public void setCollection(Collection<Object> collection) {
		if (collection.size() > 0)
			it = collection.iterator();
	}

	@Override
	public int doStartTag() throws JspException {
		if (it == null) {
			return SKIP_BODY;
		}
		return continueNext(it);
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public void doInitBody() throws JspException {

	}

	@Override
	public int doAfterBody() throws JspException {
		return continueNext(it);
	}

	/**
	 * 
	 * 保护方法，用于把it.next()设置为pagecontext的属性
	 */
	protected int continueNext(Iterator<Object> it) {
		if (it.hasNext()) {
			pageContext.setAttribute(name, it.next(), PageContext.PAGE_SCOPE);
			return EVAL_BODY_BUFFERED;
		} else {
			return SKIP_BODY;
		}
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
		return this.parent;
	}

	@Override
	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent = bodyContent;
	}

	@Override
	public void release() {
		bodyContent = null;
		parent = null;
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

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
