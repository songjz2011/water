package com.web.things.springioc.annotation;

public class SimpleMovieLister {

	private MovieFinder movieFinder;

	public MovieFinder getMovieFinder() {
		return movieFinder;
	}

	public void setMovieFinder(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}

}
