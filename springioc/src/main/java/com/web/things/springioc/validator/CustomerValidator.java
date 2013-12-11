package com.web.things.springioc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return false;
	}

	public void validate(Object target, Errors errors) {

	}

}
