package com.web.things.springioc.service.imp;

import com.web.things.springioc.dao.PersonDao;
import com.web.things.springioc.entity.Person;
import com.web.things.springioc.service.PersonService;

/**
 * @author songjz 
 * @time 2013年10月8日
 */
public class PersonServiceImp implements PersonService{
	
	private PersonDao personDao;

	public Person findById(Long id) {
		return personDao.findById(id);
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
}
