package com.web.things.springioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieAutowired {
	
	private MovieFinder finder;

	private MovieCatalog catalog;
	
	@Autowired
	private MovieFinder[] finders;

	@Autowired
	public void prepare(MovieFinder finder, MovieCatalog catalog) {
		this.finder = finder;
		this.catalog = catalog;
	}

	public MovieFinder getFinder() {
		return finder;
	}

	public MovieCatalog getCatalog() {
		return catalog;
	}

	public MovieFinder[] getFinders() {
		return finders;
	}

}
