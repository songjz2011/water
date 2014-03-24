package com.web.things.springioc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 * 用java代码来替代xml来装配Spring
 * </pre>
 * 
 * @author songjz
 * @time 2014年3月24日
 */
@Configuration
public class AppConfig {

	@Bean
	public ConfigEntity configEntity() {
		return new ConfigEntity();
	}

}
