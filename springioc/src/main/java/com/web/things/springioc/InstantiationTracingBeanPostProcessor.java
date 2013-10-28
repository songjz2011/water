package com.web.things.springioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.web.things.util.LoggerUtil;

public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		LoggerUtil.info(this.getClass(), "Bean '" + beanName + "' before created : " + bean);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		LoggerUtil.info(this.getClass(), "Bean '" + beanName + "' created : " + bean.toString());
		return bean;
	}

}
