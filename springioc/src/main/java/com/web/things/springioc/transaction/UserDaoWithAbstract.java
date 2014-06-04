package com.web.things.springioc.transaction;

public class UserDaoWithAbstract extends AbstractDao<UserDomain>{

	public static void main(String[] args) {
		UserDaoWithAbstract userDao = new UserDaoWithAbstract();
		UserDomain user = userDao.getInstance();
		System.out.println(user);
	}
	
}
