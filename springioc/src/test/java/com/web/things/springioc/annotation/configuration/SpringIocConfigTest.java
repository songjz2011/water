package com.web.things.springioc.annotation.configuration;

import static org.junit.Assert.*;

import org.junit.Test;

import com.web.things.springioc.annotation.MovieResource;
import com.web.things.springioc.factory.SpringFactoryAnnotation;

public class SpringIocConfigTest {

	@Test
	public void configration_test() {
		ConfigrationPrint bean = SpringFactoryAnnotation.getBean(ConfigrationPrint.class);
		assertNotNull(bean);
	}

	@Test
	public void configration_inteface() {
		ConfigrationService bean = SpringFactoryAnnotation.getBean(ConfigrationServiceImp1.class);
		assertEquals(ConfigrationServiceImp1.class.getSimpleName(), bean.getName());
		ConfigrationService bean1 = SpringFactoryAnnotation.getBean(ConfigrationServiceImp2.class);
		assertEquals(ConfigrationServiceImp2.class.getSimpleName(), bean1.getName());
	}

	@Test
	public void annotation_resource() {
		MovieResource bean = SpringFactoryAnnotation.getBean(MovieResource.class);
		assertNotNull(bean);
	}

	@Test
	public void annotation_resource_for_configration() {
		ConfigrationDaoService bean = SpringFactoryAnnotation.getBean(ConfigrationDaoService.class);
		assertNotNull(bean.getConfigrationDao());
	}

	@Test
	public void annotation_importresource() {
		// AnnotationImportResource bean =
		// SpringFactoryAnnotation.getBean(AnnotationImportResource.class);
		// assertEquals("www.water.com", bean.getUrl());
	}

}
