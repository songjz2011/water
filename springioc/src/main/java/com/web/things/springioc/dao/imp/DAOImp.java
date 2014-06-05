package com.web.things.springioc.dao.imp;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * <pre>
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2014年6月4日
 */
public class DAOImp<T> extends JdbcDaoSupport {

	@Resource(name = "dataSource3")
	public void setDatasource(DataSource dataSource) {
		setDataSource(dataSource);
	}

}
