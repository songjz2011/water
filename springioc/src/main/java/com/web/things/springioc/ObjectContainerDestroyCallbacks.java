package com.web.things.springioc;

import org.springframework.beans.factory.DisposableBean;

/**
 * <pre>
 * 采用spring容器，在初始化对象之后，自动 调用 某些逻辑的demo
 * 有两种实现方式：
 * 1、实现DisposableBean接口
 * 2、指定 destroy-method <bean id="objectContainerDestroyCallbacks" 
 * 		class="com.web.things.springioc.ObjectContainerDestroyCallbacks"
 * 		destroy-method="destroyMethod" />
 * 同理：spring容器，销毁对象之后，自动 调用某些逻辑的demo，参见
 * </pre>
 * 
 * @author songjz
 * @time 2013年10月25日
 */
public class ObjectContainerDestroyCallbacks implements DisposableBean {
	
	private boolean destroy = false;
	
	private boolean destroyMethod = false;

	public void destroy() throws Exception {
		destroy = true;
		System.out.println(this.getClass().getSimpleName() + " - destroy");
	}

	public void destroyMethod() {
		destroyMethod = true;
		System.out.println(this.getClass().getSimpleName() + "  destroyMethod...");
	}

	public boolean isDestroy() {
		return destroy;
	}

	public boolean isDestroyMethod() {
		return destroyMethod;
	}

}
