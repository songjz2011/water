package com.web.things.springioc.annotation;

import org.springframework.stereotype.Service;

@Service
public class MovieCatalog {

	private MovieFormat format;

	public MovieFormat getFormat() {
		return format;
	}

}
