package com.design.model.decorator;

/**
 * <pre>
 * 人 - 的装饰者 - 西装
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月10日
 */
public class PersonDecoratorBusinessSuit implements PersonDecorator {

	private PersonDecorator personDecorator;

	public void dress() {
		personDecorator.dress();
		System.out.println("    穿西装");
	}

	public void setPersonDecorator(PersonDecorator personDecorator) {
		this.personDecorator = personDecorator;
	}

}
