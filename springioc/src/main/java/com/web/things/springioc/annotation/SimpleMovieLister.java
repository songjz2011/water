package com.web.things.springioc.annotation;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Service
public class SimpleMovieLister {

	private MovieFinder movieFinder;

	public MovieFinder getMovieFinder() {
		return movieFinder;
	}

	@Required
	public void setMovieFinder(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}
	
}
