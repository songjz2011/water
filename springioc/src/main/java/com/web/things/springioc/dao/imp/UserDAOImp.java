package com.web.things.springioc.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

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
@Service
public class UserDAOImp extends DAOImp<User> implements UserDAO {

	public User findById(Long id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM USER WHERE ID=").append(id);
		User user = getJdbcTemplate().query(sql.toString(),
				new ResultSetExtractor<User>() {
					public User extractData(ResultSet rs) throws SQLException,
							DataAccessException {
						User user = null;
						if (rs.next()) {
							user = new User();
							user.setId(rs.getLong("ID"));
							user.setName(rs.getString("NAME"));
						}
						return user;
					}
				});
		return user;
	}

	public int save(User user) {
		if (user == null) {
			return 0;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO USER (NAME) VALUES (?)");
		return getJdbcTemplate().update(sql.toString(), user.getName());
	}

}
