package com.web.things.springioc.dao;

import com.web.things.springioc.entity.Person;

/**
 * @author songjz
 * @time 2013年10月8日
 */
public class PersonDao {

	public Person findById(Long id) {
		Person person = new Person();
		person.setId(id);
		person.setName("person" + id);
		person.setAddress("住址");
		return person;
	}

}
