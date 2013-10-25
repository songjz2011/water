package com.web.things.springioc;

import org.springframework.beans.factory.InitializingBean;

/**
 * <pre>
 * 采用spring容器，在初始化对象之后，自动 调用 某些逻辑的demo
 * 有两种实现方式：
 * 1、实现InitializingBean接口
 * 2、指定 init-method <bean id="objectContainerInitCallbacks" 
 * 		class="com.web.things.springioc.ObjectContainerInitCallbacks"
 * 		init-method="init" />
 * 同理：spring容器，销毁对象之后，自动 调用某些逻辑的demo，参见ObjectContainerDestroyCallbacks
 * </pre>
 * 
 * @author songjz
 * @time 2013年10月25日
 */
public class ObjectContainerInitCallbacks implements InitializingBean {

	private boolean afterPropertiesSet = false;

	private boolean init = false;

	public void afterPropertiesSet() throws Exception {
		afterPropertiesSet = true;
		System.out.println(this.getClass().getSimpleName() + "- afterPropertiesSet");
	}

	public void init() {
		init = true;
		System.out.println(this.getClass().getSimpleName() + "  init...");
	}

	public boolean isAfterPropertiesSet() {
		return afterPropertiesSet;
	}

	public boolean isInit() {
		return init;
	}

}
