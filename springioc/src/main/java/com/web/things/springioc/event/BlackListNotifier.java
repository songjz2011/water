package com.web.things.springioc.event;

import org.springframework.context.ApplicationListener;

public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

	private String notificationAddress;

	public void onApplicationEvent(BlackListEvent event) {
		System.out.println("BlackListNotifier.....");
	}

	public void setNotificationAddress(String notificationAddress) {
		this.notificationAddress = notificationAddress;
	}

	public String getNotificationAddress() {
		return notificationAddress;
	}

}
