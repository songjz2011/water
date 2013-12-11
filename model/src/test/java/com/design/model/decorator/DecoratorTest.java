package com.design.model.decorator;

import org.junit.Test;

import com.design.model.entity.Person;

public class DecoratorTest {

	@Test
	public void decorator_test() {
		Person person = new Person();
		person.setName("张三");
		PersonComponent component = new PersonComponent(person);
		PersonDecoratorBusinessSuit suit = new PersonDecoratorBusinessSuit();
		suit.setPersonDecorator(component);
		PersonDecoratorBriefs briefs = new PersonDecoratorBriefs();
		briefs.setPersonDecorator(suit);
		
		briefs.dress();
	}

}
