package com.web.things.webcms.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.web.things.webcms.entity.User;

@Service(value = "userRepository1")
public class UserRepository1 {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public User findById(Long id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM USER WHERE ID=").append(id);
		User user = getJdbcTemplate().query(sql.toString(), new ResultSetExtractor<User>() {
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
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
