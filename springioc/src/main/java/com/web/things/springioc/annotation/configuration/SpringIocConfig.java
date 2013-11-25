package com.web.things.springioc.annotation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringIocConfig {

	@Bean
	public ConfigrationPrint configrationPrint() {
		return new ConfigrationPrint();
	}

	@Bean
	public ConfigrationService configrationServiceImp1() {
		return new ConfigrationServiceImp1();
	}

	@Bean
	public ConfigrationService configrationServiceImp2() {
		return new ConfigrationServiceImp2();
	}

	@Bean
	public ConfigrationDao configrationDao() {
		return new ConfigrationDao();
	}
}
