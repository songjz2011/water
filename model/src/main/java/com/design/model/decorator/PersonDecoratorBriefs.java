package com.design.model.decorator;

/**
 * <pre>
 * 人 - 的装饰者 - 内裤
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月10日
 */
public class PersonDecoratorBriefs implements PersonDecorator {

	private PersonDecorator personDecorator;

	public void dress() {
		personDecorator.dress();
		System.out.println("    穿内裤");
	}

	public void setPersonDecorator(PersonDecorator personDecorator) {
		this.personDecorator = personDecorator;
	}
}
