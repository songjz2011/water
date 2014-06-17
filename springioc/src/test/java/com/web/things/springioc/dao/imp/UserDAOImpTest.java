package com.web.things.springioc.dao.imp;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.web.things.springioc.dao.UserDAO;
import com.web.things.springioc.entity.User;

/**
 * <pre>
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2014年6月5日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context-annotation.xml",
		"classpath:db-aop.xml" })
@ActiveProfiles("test")
//@TransactionConfiguration(transactionManager = "dataSourceTransactionManager", defaultRollback = true)
public class UserDAOImpTest {

	@Resource(name = "userDAOImp")
	private UserDAO userDAO;

	@Test
	//@Rollback(true)
	public void testSave() {
		for(int i=0; i<10; i++) {
			User user = new User();
			user.setName("张三");
			userDAO.save(user);
			if(i == 5) {
				throw new RuntimeException("ss");
			}
		}
	}

}
