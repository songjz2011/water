package com.web.things.springioc;

/**
 * @author songjz
 * @time 2013年10月12日
 */
public class ClientServiceLocator {
	private static ClientService clientService = new ClientServiceImpl();

	private ClientServiceLocator() {
	}

	public ClientService createClientServiceInstance() {
		return clientService;
	}
}
