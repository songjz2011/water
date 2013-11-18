package com.web.things.springioc.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

@Service
public class PostConstructAnnotation {

	@PostConstruct
	public void populateMovieCache() {
		System.out.println("PostConstructAnnotation.@PostConstruct test...");
	}

	@PreDestroy
	public void clearMovieCache() {
		System.out.println("PostConstructAnnotation.@@PreDestroy test...");
	}

}
