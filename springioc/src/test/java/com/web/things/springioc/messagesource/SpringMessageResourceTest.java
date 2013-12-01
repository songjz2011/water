package com.web.things.springioc.messagesource;

import java.util.Locale;

import static org.junit.Assert.*;
import org.junit.Test;

import com.web.things.springioc.factory.SpringFactory;

public class SpringMessageResourceTest {

	@Test
	public void message_resource_water_test() {
		String expected = "测试国际化-中文";
		if (languageIsEn()) {
			expected = "test-Internationalization-English";
		}
		assertEquals(expected, SpringFactory.getMessage("test.message"));
	}

	@Test
	public void message_resource_water_with_arg_test() {
		String expected = "测试国际化-我是谁-带参数";
		if (languageIsEn()) {
			expected = "test-Internationalization English-我是谁-with arguments";
		}
		assertEquals(expected, SpringFactory.getMessage("test.message.arg", new Object[] { "我是谁" }));
	}
	
	@Test
	public void message_resource_web_test() {
		String expected = "测试国际化-中文";
		if (languageIsEn()) {
			expected = "test-Internationalization-English";
		}
		assertEquals(expected, SpringFactory.getMessage("test.web.message"));
	}

	@Test
	public void message_resource_web_with_arg_test() {
		String expected = "测试国际化-我是谁-带参数";
		if (languageIsEn()) {
			expected = "test-Internationalization English-我是谁-with arguments";
		}
		assertEquals(expected, SpringFactory.getMessage("test.web.message.arg", new Object[] { "我是谁" }));
	}
	

	/**
	 * 是否是英文
	 * 
	 * @return
	 */
	private boolean languageIsEn() {
		if (SpringFactory.getLocale().getLanguage().equals(Locale.US.getLanguage())) {
			return true;
		}
		return false;
	}

}
