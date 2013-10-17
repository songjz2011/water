package com.web.things.springioc.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import com.web.things.springioc.CircularDependencyClass1;
import com.web.things.springioc.CircularDependencyClass2;
import com.web.things.springioc.ClientService;
import com.web.things.springioc.ClientServiceLocator;
import com.web.things.springioc.ExampleBean;
import com.web.things.springioc.ExampleBean1;
import com.web.things.springioc.ExampleBean2;
import com.web.things.springioc.ExampleBean3;
import com.web.things.springioc.FirstIoc;
import com.web.things.springioc.IdRefBean;
import com.web.things.springioc.dao.DAOProperties;

/**
 * @author songjz
 * @time 2013年9月30日
 */
public class SpringFactoryTest {

	@Test
	public void get_bean_is_not_null() {
		Object obj = SpringFactory.getBean("firstIoc");
		assertNotNull(obj);
		FirstIoc ioc = SpringFactory.getBean("firstIoc", FirstIoc.class);
		assertNotNull(ioc);
	}

	@Test(expected = NoSuchBeanDefinitionException.class)
	public void get_bean_is_null() {
		Object obj = SpringFactory.getBean("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertNull(obj);
	}

	@Test
	public void get_bean_for_alias_is_not_null() {
		FirstIoc ico = SpringFactory.getBean("secondIoc", FirstIoc.class);
		assertNotNull(ico);
	}

	@Test
	public void get_bean_for_singleton_is_not_null() {
		Object obj = SpringFactory.getBean("singletonClass");
		assertNotNull(obj);
	}

	@Test
	public void get_bean_for_clientServiceLocator_is_not_null() {
		ClientServiceLocator locator = SpringFactory.getBean("clientServiceLocator",
				ClientServiceLocator.class);
		assertNotNull(locator.createClientServiceInstance());
		ClientService service = SpringFactory.getBean("clientService", ClientService.class);
		assertNotNull(service);

		assertEquals(locator.createClientServiceInstance(), service);
	}

	@Test
	public void get_bean_for_constructor_is_not_null() {
		ExampleBean bean = SpringFactory.getBean("exampleBeanConstructor", ExampleBean.class);
		assertNotNull(bean);
		System.out.println(bean.getName());

		ExampleBean bean1 = SpringFactory.getBean("exampleBeanConstructor", ExampleBean.class);
		assertEquals(bean, bean1);
	}

	@Test
	public void get_bean_for_constructor_annotation_is_not_null() {
		ExampleBean1 bean = SpringFactory.getBean("exampleBeanConstructor1", ExampleBean1.class);
		assertNotNull(bean);
		System.out.println(bean.getUltimateAnswer());
	}

	@Test
	public void get_bean_for_private_constructor_is_not_null() {
		ExampleBean3 bean = SpringFactory.getBean("exampleBean3", ExampleBean3.class);
		assertNotNull(bean);
		bean.getAnother().print();
	}

	@Test
	public void get_bean_for_propertyname_not_equals_setname() {
		ExampleBean2 bean = SpringFactory.getBean("exampleBean2", ExampleBean2.class);
		assertEquals("中国", bean.getAddress());
		System.out.println(bean.getAddress());
	}

	// @Test
	// public void get_bean_for_use_p_namespace_for_even_more_succinct_xml() {
	// ExampleBean2 bean = SpringFactory.getBean("exampleBean2ForP",
	// ExampleBean2.class);
	// assertEquals("北京", bean.getAddress());
	// System.out.println(bean.getAddress());
	// }

	@Test
	public void get_bean_for_circular_dependency_is_not_null() {
		CircularDependencyClass1 bean1 = SpringFactory.getBean("circularDependencyClass1",
				CircularDependencyClass1.class);
		assertNotNull(bean1);
		bean1.print();

		CircularDependencyClass2 bean2 = SpringFactory.getBean("circularDependencyClass2",
				CircularDependencyClass2.class);
		assertNotNull(bean2);
		bean2.print();
	}

	@Test
	public void get_bean_for_properties_test() {
		DAOProperties bean = SpringFactory.getBean("DAOPropertiesTest", DAOProperties.class);
		assertNotNull(bean);
		System.out.println(bean.getProperties().get("name"));
		DAOProperties bean2 = SpringFactory.getBean("DAOPropertiesTest2", DAOProperties.class);
		System.out.println(bean2.getProperties().get("name"));
	}

	@Test
	public void idref_validate() {
		IdRefBean bean = SpringFactory.getBean("idRefBean", IdRefBean.class);
		assertNotNull(bean);
		System.out.println(bean.getBeanName());
	}

}
