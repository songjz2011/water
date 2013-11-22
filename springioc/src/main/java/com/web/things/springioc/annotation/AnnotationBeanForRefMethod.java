package com.web.things.springioc.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AnnotationBeanForRefMethod {

	@Bean
	public MovieFinder movieFinder() {
		return new MovieFinder();
	}

}
