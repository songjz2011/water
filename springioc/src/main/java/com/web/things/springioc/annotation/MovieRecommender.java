package com.web.things.springioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieRecommender {

	@Autowired
	//@MovieQualifier(format = MovieFormat.VHS, genre = "Action")
	private MovieCatalog actionVhsCatalog;

}
