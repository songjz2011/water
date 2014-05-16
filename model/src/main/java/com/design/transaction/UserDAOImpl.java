package com.design.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <pre>
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2014年5月16日
 */
public class UserDAOImpl implements UserDAO {

	public User find(String id) {
		ResultSet resu = null;
		String sql = "SELECT * FROM T_USER WHERE USER_ID = ?";
		Connection conn = ConnectionManager.getConnection();
		User user = null;
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			resu = pstat.executeQuery();
			if (resu.next()) {
				user = getUser(resu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resu != null) {
					resu.close();
				}
				if (pstat != null) {
					pstat.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	// 获取用户
	private User getUser(ResultSet resu) throws SQLException {
		User user = new User();
		user.setId(resu.getString("USER_ID"));
		user.setName(resu.getString("USER_NAME"));
		user.setPassword(resu.getString("PASSWORD"));
		user.setContact_tel(resu.getString("CONTACT_TEL"));
		user.setEmail(resu.getString("EMAIL"));
		user.setCreate_date(resu.getTimestamp("CREATE_DATE"));
		return user;
	}

}
