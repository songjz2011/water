package com.web.things.springioc.annotation.javax;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.web.things.springioc.factory.SpringFactory;

public class SpringJavaxAnnotationTest {

	@Test
	public void annotation_javax_named() {
		AnnotationJavaxNamed bean = SpringFactory.getBeanByDefaultId(AnnotationJavaxNamed.class);
		assertNotNull(bean);
	}
	
	@Test
	public void annotation_javax_inject() {
		AnnotationJavaxInject bean = SpringFactory.getBeanByDefaultId(AnnotationJavaxInject.class);
		assertNotNull(bean);
		assertNotNull(bean.getAnnotationJavaxNamed());
	}
	
}
