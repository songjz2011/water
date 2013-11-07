package com.web.things.springioc.annotation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.web.things.springioc.factory.SpringFactory;

public class SpringAnnotationTest {

	@Test
	public void test_annotation_service() {
		MovieFinder bean= SpringFactory.getBeanByDefaultId(MovieFinder.class);
		assertNotNull(bean);
	}
	
	@Test
	public void test_anotation_autowired() {
		MovieAutowired bean = SpringFactory.getBeanByDefaultId(MovieAutowired.class);
		assertNotNull(bean.getCatalog());
		MovieFinder[] finders = bean.getFinders();
		assertNotNull(finders);
		for(MovieFinder finder : finders) {
			System.out.println(finder);
		}
	}
	
	@Test
	public void test_anotation_resource() {
		MovieResource bean = SpringFactory.getBeanByDefaultId(MovieResource.class);
		assertNotNull(bean.getFinder());
	}
	
}
