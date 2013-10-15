package com.web.things.springioc.service.imp;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.web.things.springioc.entity.Person;
import com.web.things.springioc.factory.SpringFactory;
import com.web.things.springioc.service.PersonService;

/**
 * @author songjz
 * @time 2013年10月8日
 */
public class PersonServiceImpTest {

	private static PersonService service;

	@BeforeClass
	public static void beforeClass() {
		service = (PersonService) SpringFactory.getBean("personService");
	}
	
	@Test
	public void service_is_not_null() {
		assertNotNull(service);
	}
	
	@Test
	public void service_find_person_is_not_null() {
		Long id = 1L;
		Person person = service.findById(id);
		assertNotNull(person);
	}

}
