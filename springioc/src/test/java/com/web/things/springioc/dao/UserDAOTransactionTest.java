package com.web.things.springioc.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.web.things.springioc.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context-annotation.xml",
		"classpath:db-transatcion.xml" })
@TransactionConfiguration(defaultRollback = false)
@ActiveProfiles(value = { "test" })
public class UserDAOTransactionTest {

	@Resource
	private UserDAO userDAO;

	@Test
	@Transactional(readOnly = false)
	public void test() {
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setName("张三");
			userDAO.save(user);
			if (i == 5) {
				throw new RuntimeException();
			}
		}
	}

}
