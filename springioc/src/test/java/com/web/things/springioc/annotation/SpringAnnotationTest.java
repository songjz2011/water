package com.web.things.springioc.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map.Entry;

import org.junit.Test;

import com.web.things.springioc.factory.SpringFactory;

public class SpringAnnotationTest {

	@Test
	public void test_annotation_service() {
		MovieFinder bean = SpringFactory.getBeanByDefaultId(MovieFinder.class);
		assertNotNull(bean);
	}

	@Test
	public void test_anotation_autowired() {
		MovieAutowired bean = SpringFactory.getBeanByDefaultId(MovieAutowired.class);
		assertNotNull(bean.getCatalog());
		assertEquals(2, bean.getFinders().length);
		assertEquals(2, bean.getFinderList().size());
		assertEquals(2, bean.getFinderSet().size());
		assertEquals(2, bean.getFinderMap().size());
		for (Entry<String, MovieFinder> entry : bean.getFinderMap().entrySet()) {
			System.out.print(entry.getKey() + "---" + entry.getValue());
			System.out.println();
		}
	}

	@Test
	public void test_anotation_resource() {
		MovieResource bean = SpringFactory.getBeanByDefaultId(MovieResource.class);
		assertNotNull(bean.getCatalog());
		assertEquals(2, bean.getFinders().length);
		assertEquals(2, bean.getFinderList().size());
		assertEquals(2, bean.getFinderSet().size());
		assertEquals(2, bean.getFinderMap().size());
		for (Entry<String, MovieFinder> entry : bean.getFinderMap().entrySet()) {
			System.out.print(entry.getKey() + "---" + entry.getValue());
			System.out.println();
		}
	}
	
	@Test
	public void annotation_service_factory_service() {
		AnnotationServiceFactory bean = SpringFactory.getBeanByDefaultId(AnnotationServiceFactory.class);
		assertEquals("address", bean.getAddressServiceResource().find());
		assertEquals("address", bean.getAddressServiceAutoWired().find());
	}
	
	@Test
	public void annotation_MovieRecommender() {
		MovieRecommender bean = SpringFactory.getBeanByDefaultId(MovieRecommender.class);
		assertNotNull(bean);
	}
	
	@Test
	public void annotation_PostConstruct() {
		PostConstructAnnotation bean = SpringFactory.getBeanByDefaultId(PostConstructAnnotation.class);
		System.out.println(bean);
		SpringFactory.getContext().registerShutdownHook();
	}

}
