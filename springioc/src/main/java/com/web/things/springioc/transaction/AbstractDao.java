package com.web.things.springioc.transaction;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class AbstractDao<T extends Domain> {

	public T getInstance() {
		T bean = null;

		Class<?> clazz = getClass();

		ParameterizedType genericSuperclass = (ParameterizedType) clazz.getGenericSuperclass();

		return bean;
	}

	public static void main(String[] args) {
		UserDaoWithAbstract userDao = new UserDaoWithAbstract();
		UserDomain user = userDao.getInstance();
		System.out.println(user);
	}

	public T getNewInstance() {
		Class<T> claz = null;
		try {
			// 如果是 子类 直接 继承DaoImpl
			Class<? extends AbstractDao> class1 = (Class<? extends AbstractDao>) getClass();
			ParameterizedType genericSuperclass = (ParameterizedType) class1.getGenericSuperclass();
			claz = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
		} catch (Exception e) {
			// 如果异常可能是 子类 继承DaoImpl的实现类
			try {
				Class<? extends AbstractDao> class1 = (Class<? extends AbstractDao>) getClass()
						.getSuperclass();
				ParameterizedType genericSuperclass = (ParameterizedType) class1
						.getGenericSuperclass();
				claz = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		T bean = null;
		try {
			bean = claz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

}
