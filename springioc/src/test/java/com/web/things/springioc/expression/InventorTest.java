package com.web.things.springioc.expression;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * <pre>
 * spring 表达式语言
 * </pre>
 * 
 * @author songjz
 * @time 2014年4月8日
 */
public class InventorTest {

	@Test
	public void test() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'.bytes");
		byte[] bytes = exp.getValue(byte[].class);
		System.out.println(bytes);

		Expression exp1 = parser.parseExpression("'Hello World'.toUpperCase()");
		String message = exp1.getValue(String.class);
		System.out.println(message);

		Inventor inventor = new Inventor();
		inventor.setName("Nikola Tesla");
		inventor.setNationality("Serbian");
		inventor.setBirthday(new Date());
		List<String> list = new ArrayList<String>();
		list.add("我是谁的集合");
		inventor.setList(list);
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "a=hello啊");
		inventor.setMap(map);

		Expression exp2 = parser.parseExpression("name");
		EvaluationContext context = new StandardEvaluationContext(inventor);
		System.out.println(exp2.getValue(context));

		Expression exp3 = parser.parseExpression("name");
		System.out.println(exp3.getValue(inventor));

		Expression exp4 = parser.parseExpression("name == 'Nikola Tesla'");
		boolean result = exp4.getValue(inventor, Boolean.class);
		System.out.println(result);

		// list测试
		Expression exp5 = parser.parseExpression("list[0]");
		String listValue = exp5.getValue(inventor, String.class);
		System.out.println(listValue);

		// map测试
		Expression exp6 = parser.parseExpression("map['a']");
		String mapValue = exp6.getValue(inventor, String.class);
		System.out.println(mapValue);

		// 设置值 测试
		parser.parseExpression("nationality").setValue(inventor, "我是谁");
		String nationality = parser.parseExpression("nationality").getValue(inventor, String.class);
		System.out.println(nationality);
		String aleks = parser.parseExpression("nationality = 'Alexandar Seovic---------=='").getValue(inventor,
                String.class);
		System.out.println(aleks);


		// 方法测试
		Expression exp7 = parser.parseExpression("hello('朋友们')");
		String method = exp7.getValue(inventor, String.class);
		System.out.println(method);

		// evaluates to true
		boolean compareValue = parser.parseExpression("2 == 2").getValue(Boolean.class);
		System.out.println(compareValue);

		// evaluates to false
		boolean instanceValue = parser.parseExpression("'xyz' instanceof T(int)").getValue(
				Boolean.class);
		System.out.println(instanceValue);

		// evaluates to true
		boolean regularValue = parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'")
				.getValue(Boolean.class);
		System.out.println(regularValue);

		// Addition
		int two = parser.parseExpression("1 + 1").getValue(Integer.class); // 2
		System.out.println(two);

		String testString = parser.parseExpression("'test' + ' ' + 'string'")
				.getValue(String.class); // 'test string'
		System.out.println(testString);

		// -- AND --
		// evaluates to false
		boolean andValue = parser.parseExpression("true and false").getValue(Boolean.class);
		System.out.println(andValue);

		// -- OR --
		// evaluates to true
		boolean orValue = parser.parseExpression("true or false").getValue(Boolean.class);
		System.out.println(orValue);
		
		Class<?> dateClass = parser.parseExpression("T(java.util.Date)").getValue(Class.class);
		System.out.println(dateClass.getName());
	}

}
