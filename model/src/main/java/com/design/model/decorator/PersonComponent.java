package com.design.model.decorator;

import com.design.model.entity.Person;

/**
 * <pre>
 * 人 - 装饰者的入口(或者是第一次调用的方式)
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月10日
 */
public class PersonComponent implements PersonDecorator {

	private Person person;

	public PersonComponent(Person person) {
		this.person = person;
	}

	public void dress() {
		System.out.println(this.person.getName() + " 穿什么衣服呢？");
	}

}
