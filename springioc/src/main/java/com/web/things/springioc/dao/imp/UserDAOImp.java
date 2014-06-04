package com.web.things.springioc.dao.imp;

import org.springframework.jdbc.core.JdbcTemplate;

import com.web.things.springioc.dao.UserDAO;
import com.web.things.springioc.entity.User;

/**
 * <pre>
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2014年6月4日
 */
public class UserDAOImp extends JdbcTemplate implements UserDAO {

	public User findById(Long id) {
		return null;
	}

	public void save(User user) {

	}

}
