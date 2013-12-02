package com.web.things.springioc.event;

import org.junit.Test;

import com.web.things.springioc.factory.SpringFactory;

public class EmailServiceTest {

	@Test
	public void send_email_listener() {
		EmailService service = SpringFactory.getBeanByDefaultId(EmailService.class);
		service.sendEmail("john.doe@example.org", "邮件内容");
	}

}
