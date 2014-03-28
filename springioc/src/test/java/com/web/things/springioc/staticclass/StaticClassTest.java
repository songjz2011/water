package com.web.things.springioc.staticclass;

import org.springframework.core.convert.converter.Converter;

public class StaticClassTest {

	private static final class StaticClass<T extends Number> implements Converter<String, T>{

		public T convert(String source) {
			return null;
		}
		
	}
	
}
