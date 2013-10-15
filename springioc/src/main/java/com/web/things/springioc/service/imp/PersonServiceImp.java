package com.web.things.springioc.service.imp;

import com.web.things.springioc.dao.PersonDAO;
import com.web.things.springioc.entity.Person;
import com.web.things.springioc.service.PersonService;

/**
 * @author songjz 
 * @time 2013年10月8日
 */
public class PersonServiceImp implements PersonService{
	
	private PersonDAO personDAO;

	public Person findById(Long id) {
		return personDAO.findById(id);
	}

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

}
