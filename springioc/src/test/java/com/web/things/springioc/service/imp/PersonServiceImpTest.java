package com.web.things.springioc.service.imp;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
	
	@Test
	public void aa() {
		List<Integer> result = new ArrayList<Integer>();
		int startM= 12;
		int endM = 5;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MONTH, startM - 1);
		
		boolean isEnd = true;
		while(isEnd) {
			int month = calendar.get(Calendar.MONTH) + 1;
			result.add(month);
			calendar.add(Calendar.MONTH, 1);
			if(month == endM) {
				isEnd = false;
			}
		}
		System.out.println(result);
	}

}
