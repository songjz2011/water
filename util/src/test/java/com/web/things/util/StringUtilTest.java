package com.web.things.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.web.things.util.StringUtil;

/**
 * @author songjz
 * @time 2013年7月26日
 */
public class StringUtilTest {

	@Test
	public void null_string_object_should_be_empty() {
		String expected = null;
		assertTrue(StringUtil.isEmpty(expected));
	}

	@Test
	public void null_string_should_be_empty() {
		String expected = "null";
		assertTrue(StringUtil.isEmpty(expected));
	}

	@Test
	public void empty_string_should_be_empty() {
		String expected = " ";
		assertTrue(StringUtil.isEmpty(expected));
	}

}
