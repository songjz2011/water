package com.web.things.webcms.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.web.things.webcms.entity.Person;

public class PersonValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
		Person p = (Person) target;
		if (p.getAge() < 0) {
			errors.reject("age", "negativevalue");
		} else if (p.getAge() > 110) {
			errors.reject("age", "too.darn.old");
		}
	}

}
