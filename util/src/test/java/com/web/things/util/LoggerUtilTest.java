package com.web.things.util;

import org.junit.Test;

public class LoggerUtilTest {

	@Test
	public void test() {
		LoggerUtil.info(LoggerUtilTest.class, "log test...");
	}
	
}
