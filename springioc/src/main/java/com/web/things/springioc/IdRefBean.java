package com.web.things.springioc;

/**
 * <pre>
 * 标签idref测试bean
 * </pre>
 * 
 * @author songjz
 * @time 2013年10月17日
 */
public class IdRefBean {

	private String beanName;

	public IdRefBean() {

	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

}
