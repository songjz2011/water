package com.design.model.decorator;

/**
 * <pre>
 * 人 - 的装饰者 - t恤
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月10日
 */
public class PersonDecoratorTShirt implements PersonDecorator {

	private PersonDecorator personDecorator;

	public void dress() {
		personDecorator.dress();
		System.out.println("    穿T恤");
	}

	public void setPersonDecorator(PersonDecorator personDecorator) {
		this.personDecorator = personDecorator;
	}

}
