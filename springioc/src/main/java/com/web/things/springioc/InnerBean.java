package com.web.things.springioc;

/**
 * <pre>
 * 内部类spring初始化测试（即：对ExampleBean 在spring中进行初始化，而不是ref）
 * </pre>
 * 
 * @author songjz
 * @time 2013年10月17日
 */
public class InnerBean {

	private ExampleBean bean;

	public InnerBean() {

	}

	public ExampleBean getBean() {
		return bean;
	}

	public void setBean(ExampleBean bean) {
		this.bean = bean;
	}

}
