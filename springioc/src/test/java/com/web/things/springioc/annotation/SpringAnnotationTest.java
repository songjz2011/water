package com.web.things.springioc.annotation;

import static org.junit.Assert.*;

import java.util.Map.Entry;

import org.junit.Test;

import com.web.things.springioc.entity.Person;
import com.web.things.springioc.factory.SpringFactory;

import extra.entity.ExtraEntity;

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
		AnnotationServiceFactory bean = SpringFactory
				.getBeanByDefaultId(AnnotationServiceFactory.class);
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
		PostConstructAnnotation bean = SpringFactory
				.getBeanByDefaultId(PostConstructAnnotation.class);
		System.out.println(bean);
		SpringFactory.getContext().registerShutdownHook();
	}

	@Test
	public void annotation_config_include_filter() {
		ExtraEntity bean = SpringFactory.getBeanByDefaultId(ExtraEntity.class);
		assertNotNull(bean);
	}

	@Test
	public void annotation_component() {
		AnnotationComponent bean = SpringFactory.getBeanByDefaultId(AnnotationComponent.class);
		assertNotNull(bean);
	}

	@Test
	public void annotation_bean() {
		AnnotationBean bean = SpringFactory.getBeanByDefaultId(AnnotationBean.class);
		Person publicPerson = bean.publicInstance();
		assertNotNull(publicPerson);
		Person test = new Person();
		test.setAddress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa dress");
		Person protectedPerson = bean.protectedInstance(test, test.getAddress());
		assertNotNull(protectedPerson);
		// assertEquals("publicInstance address", protectedPerson.getAddress());
	}
	
	@Test
	public void annotation_bean_for_ref_method() {
		AnnotationBeanForRefMethod bean = SpringFactory.getBeanByDefaultId(AnnotationBeanForRefMethod.class);
		assertNotNull(bean);
		assertNotNull(bean.movieFinder());
	}

	@Test
	public void annotation_qualifier_for_class() {
		AnnotationQualifierForClass bean = SpringFactory
				.getBeanByDefaultId(AnnotationQualifierForClass.class);
		assertNotNull(bean);
//		AnnotationQualifierForClass bean1 = SpringFactory.getBean("annotationQualifier",
//				AnnotationQualifierForClass.class);
//		assertNotNull(bean1);
	}
}
