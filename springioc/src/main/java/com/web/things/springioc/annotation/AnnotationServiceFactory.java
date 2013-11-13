package com.web.things.springioc.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * 面向接口的注入，接口若有多个实现，使用时需要指定使用的是哪个具体的实现
 * 1、@Resourc需要设定name值
 * 2、@Autowired需要和@Qualifier结合使用
 * </pre>
 * 
 * @author songjz
 * @time 2013年11月8日
 */
@Service
public class AnnotationServiceFactory {

	@Resource(name = "annotationServiceAddress")
	protected IAnnotationSerivce addressServiceResource;

	@Resource(name = "annotationServiceName")
	private IAnnotationSerivce nameServiceResource;

	@Autowired
	@Qualifier(value = "annotationServiceAddress")
	private IAnnotationSerivce addressServiceAutoWired;

	@Autowired
	@Qualifier(value = "annotationServiceName")
	private IAnnotationSerivce nameServiceAutoWired;

	public IAnnotationSerivce getAddressServiceResource() {
		return addressServiceResource;
	}

	public IAnnotationSerivce getNameServiceResource() {
		return nameServiceResource;
	}

	public IAnnotationSerivce getAddressServiceAutoWired() {
		return addressServiceAutoWired;
	}

	public IAnnotationSerivce getNameServiceAutoWired() {
		return nameServiceAutoWired;
	}

}
