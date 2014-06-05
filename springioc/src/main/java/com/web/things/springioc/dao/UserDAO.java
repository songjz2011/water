package com.web.things.springioc.dao;

import com.web.things.springioc.entity.User;

/**
 * <pre>类描述</pre>
 * @author songjz 
 * @time 2014年6月4日
 */
public interface UserDAO {

	User findById(Long id);
	
	int save(User user);
	
}
