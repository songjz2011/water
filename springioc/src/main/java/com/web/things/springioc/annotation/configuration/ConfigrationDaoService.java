package com.web.things.springioc.annotation.configuration;

public class ConfigrationDaoService {

	private ConfigrationDao configrationDao;

	public void setConfigrationDao(ConfigrationDao configrationDao) {
		this.configrationDao = configrationDao;
	}

	public ConfigrationDao getConfigrationDao() {
		return configrationDao;
	}

}
