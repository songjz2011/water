package com.web.things.springioc.service;

import com.web.things.springioc.entity.Person;

/**
 * @author songjz
 * @time 2013年10月8日
 */
public interface PersonService {
	
	Person findById(Long id);
	
}
