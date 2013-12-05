package com.net.url;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlXml {

	public URL getUrlXml() {
		String path = UrlXml.class.getClassLoader().getResource("url_xml.xml").getPath();
		try {
			return new URL("file:" + path);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
		// return UrlXml.class.getClassLoader().getResource("url_xml.xml");
	}

	public URL getBaidu() {
		try {
			return new URL("http://www.baidu.com");
			// return new URL("http", "www.baidu.com", null);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public URL getLocalhost() {
		try {
			return new URL("http://localhost:8080/huabeinew/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
