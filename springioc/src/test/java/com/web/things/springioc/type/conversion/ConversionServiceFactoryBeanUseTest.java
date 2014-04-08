package com.web.things.springioc.type.conversion;

import org.junit.Test;

import com.web.things.springioc.factory.SpringFactoryMvc;

public class ConversionServiceFactoryBeanUseTest {

	@Test
	public void tes() {
		ConversionServiceFactoryBeanUse use = SpringFactoryMvc
				.getBeanByDefaultId(ConversionServiceFactoryBeanUse.class);
		use.print();
	}

}
