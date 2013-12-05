package com.design.model.factory;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperateFactoryTest {

	@Test
	public void test_factory() {
		Operate bean = OperateFactory.createOperate(OperateEnum.ADD);
		assertNotNull(bean);
	}

	@Test
	public void test_assert_that() {
		// allOf
	}

}
