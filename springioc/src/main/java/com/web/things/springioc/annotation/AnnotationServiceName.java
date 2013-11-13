package com.web.things.springioc.annotation;

import org.springframework.stereotype.Service;

@Service
public class AnnotationServiceName implements IAnnotationSerivce {

	public String find() {
		return "name";
	}

}
