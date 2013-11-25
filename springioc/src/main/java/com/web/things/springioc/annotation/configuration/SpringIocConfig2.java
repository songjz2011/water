package com.web.things.springioc.annotation.configuration;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringIocConfig2 {

	@Resource
	private ConfigrationDao configrationDao;

	@Bean
	public ConfigrationDaoService configrationDaoService() {
		ConfigrationDaoService service = new ConfigrationDaoService();
		service.setConfigrationDao(configrationDao);
		return service;
	}

}
