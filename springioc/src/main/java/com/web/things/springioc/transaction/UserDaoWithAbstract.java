package com.web.things.springioc.transaction;

public class UserDaoWithAbstract extends AbstractDao<User>{

	public static void main(String[] args) {
		UserDaoWithAbstract userDao = new UserDaoWithAbstract();
		User user = userDao.getInstance();
		System.out.println(user);
	}
	
}
