package com.web.things.springioc.dao.imp;

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
	
	public T query(String sql) {
		return null;
	}
}
