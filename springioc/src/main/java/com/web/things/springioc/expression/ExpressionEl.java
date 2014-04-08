package com.web.things.springioc.expression;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * <pre>
 * spring 表达式语言
 * </pre>
 * 
 * @author songjz
 * @time 2014年4月8日
 */
public class ExpressionEl {

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'.concat('!')");
		String message = (String) exp.getValue();
		System.out.println(message);
	}

}
