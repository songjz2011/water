package com.web.things.webcms.repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class Repository<T> extends JdbcDaoSupport {

	@Resource(name = "dataSource3")
	public void setDatasource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
