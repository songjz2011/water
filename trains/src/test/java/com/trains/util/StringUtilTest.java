package com.trains.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.trains.util.StringUtil;

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
	
	@Test
	public void common_string_should_not_be_empty() {
		String expected = "test";
		assertFalse(StringUtil.isEmpty(expected));
	}

}
