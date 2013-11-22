package com.web.things.springioc.factory;

import static org.junit.Assert.*;
import org.junit.Test;

import com.web.things.springioc.annotation.MovieResource;

public class SpringFactoryAnnotationTest {

	@Test
	public void annotation_class_not_null() {
		MovieResource bean = SpringFactoryAnnotation.getBean(MovieResource.class);
		assertNotNull(bean);
	}
	
}
