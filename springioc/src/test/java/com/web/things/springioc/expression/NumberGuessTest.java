package com.web.things.springioc.expression;

import org.junit.Test;

import com.web.things.springioc.factory.SpringFactory;

public class NumberGuessTest {

	@Test
	public void test() {
		NumberGuess obj = SpringFactory.getBeanByDefaultId(NumberGuess.class);
		System.out.println(obj.getRandomNumber());
		System.out.println(obj.getDefaultLocale());
		System.out.println(obj.getName());
		System.out.println(obj.getAddress());
		System.out.println("---");
		
		ShapeGuess shap = SpringFactory.getBeanByDefaultId(ShapeGuess.class);
		System.out.println(shap.getInitialShapeSeed());
	}

}
