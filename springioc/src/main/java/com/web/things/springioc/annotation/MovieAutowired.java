package com.web.things.springioc.annotation;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieAutowired {

	private MovieCatalog catalog;

	@Autowired
	public void prepare(MovieCatalog catalog) {
		this.catalog = catalog;
	}

	public MovieCatalog getCatalog() {
		return catalog;
	}

	@Autowired
	private MovieFinder[] finders;
	
	@Autowired
	private List<MovieFinder> finderList;
	
	@Autowired
	private Set<MovieFinder> finderSet;
	
	@Autowired
	private Map<String, MovieFinder> finderMap;
	
	public MovieFinder[] getFinders() {
		return finders;
	}

	public List<MovieFinder> getFinderList() {
		return finderList;
	}

	public Set<MovieFinder> getFinderSet() {
		return finderSet;
	}

	public Map<String, MovieFinder> getFinderMap() {
		return finderMap;
	}

}
