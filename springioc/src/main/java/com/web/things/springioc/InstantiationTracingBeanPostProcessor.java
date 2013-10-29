package com.web.things.springioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import com.web.things.util.LoggerUtil;

/**
 * <pre>
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2013年10月28日
 */
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor, Ordered {

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		LoggerUtil.info(this.getClass(), "Bean '" + beanName + "' before created : " + bean);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		LoggerUtil.info(this.getClass(), "Bean '" + beanName + "' created : " + bean);
		return bean;
	}

	public int getOrder() {
		return 0;
	}

}
