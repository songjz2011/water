package com.web.things.springioc.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import com.web.things.springioc.CircularDependencyClass1;
import com.web.things.springioc.CircularDependencyClass2;
import com.web.things.springioc.ClientService;
import com.web.things.springioc.ClientServiceLocator;
import com.web.things.springioc.CollectionBean;
import com.web.things.springioc.ExampleBean;
import com.web.things.springioc.ExampleBean1;
import com.web.things.springioc.ExampleBean2;
import com.web.things.springioc.ExampleBean3;
import com.web.things.springioc.FirstIoc;
import com.web.things.springioc.FirstIocForPrototype;
import com.web.things.springioc.IdRefBean;
import com.web.things.springioc.InnerBean;
import com.web.things.springioc.MyValueCalculator;
import com.web.things.springioc.dao.DaoProperties;
import com.web.things.springioc.manager.CommandManager1;

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
	public void scope_prototype_for_bean() {
		FirstIocForPrototype bean = SpringFactory.getBean("firstIocForPrototype",
				FirstIocForPrototype.class);
		FirstIocForPrototype bean1 = SpringFactory.getBean("firstIocForPrototype",
				FirstIocForPrototype.class);
		// System.out.println("FirstIocForPrototype.ioc : " + bean.getIoc());
		// System.out.println("FirstIocForPrototype.ioc1 : " + bean1.getIoc());
		assertNotSame(bean, bean1);
		assertEquals(bean.getIoc(), bean1.getIoc());

		FirstIoc ioc = SpringFactory.getBean("firstIoc", FirstIoc.class);
		FirstIoc ioc1 = SpringFactory.getBean("firstIoc", FirstIoc.class);
		// System.out.println("FirstIoc.prototype : " + ioc.getPrototype());
		// System.out.println("FirstIoc.prototype1 : " + ioc1.getPrototype());
		assertEquals(ioc.getPrototype(), ioc1.getPrototype());
	}

	@Test
	public void get_bean_two_id_for_same_bean() {
		FirstIoc ioc = SpringFactory.getBean("firstIoc", FirstIoc.class);
		FirstIoc ioc1 = SpringFactory.getBean("firstIoc1", FirstIoc.class);
		// System.out.println("ioc = " + ioc);
		// System.out.println("ioc1 = " + ioc1);
		assertNotSame(ioc, ioc1);
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
		DaoProperties bean = SpringFactory.getBean("DAOPropertiesTest", DaoProperties.class);
		assertNotNull(bean);
		System.out.println(bean.getProperties().get("name"));
		DaoProperties bean2 = SpringFactory.getBean("DAOPropertiesTest2", DaoProperties.class);
		System.out.println(bean2.getProperties().get("name"));
	}

	@Test
	public void idref_validate() {
		IdRefBean bean = SpringFactory.getBean("idRefBean", IdRefBean.class);
		assertNotNull(bean);
		System.out.println(bean.getBeanName());
	}

	@Test
	public void inner_bean_spring_init() {
		InnerBean bean1 = SpringFactory.getBean("innerBean", InnerBean.class);
		assertNotNull(bean1);
		InnerBean bean2 = SpringFactory.getBean("innerBean", InnerBean.class);
		assertEquals(bean1, bean2);

		// 内部的实例 和 外部 的实例 不一样
		ExampleBean exampleBeanConstructor = SpringFactory.getBean("exampleBeanConstructor",
				ExampleBean.class);
		assertNotSame(bean1, exampleBeanConstructor);
	}

	@Test
	public void collection_property() {
		CollectionBean bean = SpringFactory.getBean("collectionBean", CollectionBean.class);
		StringBuffer print = new StringBuffer();
		String[] array = bean.getArray();
		print.append("打印数组：");
		for (String str : array) {
			print.append(str).append(",");
		}
		System.out.println(print);
		print.delete(0, print.length());

		Properties pro = bean.getEmails();
		System.out.println(pro);

		List<String> list = bean.getList();
		System.out.println(list);

		Map<String, String> map = bean.getMap();
		System.out.println(map);

		Set<String> set = bean.getSet();
		System.out.println(set);
	}

	@Test
	public void collection_property_merge() {
		CollectionBean bean = SpringFactory.getBean("collectionBeanMerge", CollectionBean.class);
		Properties pro = bean.getEmails();
		System.out.println(pro);

		CollectionBean bean1 = SpringFactory.getBean("collectionBean", CollectionBean.class);
		assertNotSame(bean, bean1);
	}

	@Test
	public void lookup_method_test() {
		CommandManager1 bean = SpringFactory.getBean("commandManager1", CommandManager1.class);
		bean.createCommand().execute();
	}

	@Test
	public void replace_method_test() {
		MyValueCalculator calculator = SpringFactory.getBean("myValueCalculator",
				MyValueCalculator.class);
		calculator.computeValue("我是谁");
	}
}
