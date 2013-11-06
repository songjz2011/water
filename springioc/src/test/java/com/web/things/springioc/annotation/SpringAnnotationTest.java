package com.web.things.springioc.annotation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.web.things.springioc.factory.SpringFactory;

public class SpringAnnotationTest {

	@Test
	public void test_annotation_service() {
		MovieFinder finder = SpringFactory.getBeanByDefaultId(MovieFinder.class);
		assertNotNull(finder);
	}
	
}
