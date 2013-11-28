package com.web.things.springioc.annotation.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
// @ImportResource(value = "classpath:spring-context-properties.xml")
public class AnnotationImportResource {

	@Value("${test.url}")
	private String url;

	public String getUrl() {
		return url;
	}

}
