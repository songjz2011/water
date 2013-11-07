package com.web.things.springioc.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class MovieResource {
	
	@Resource
	private MovieFinder finder;

	public MovieFinder getFinder() {
		return finder;
	}
}
