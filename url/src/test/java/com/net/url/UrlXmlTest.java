package com.net.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;

public class UrlXmlTest {

	private static UrlXml urlXml;

	@BeforeClass
	public static void beforeClass() {
		urlXml = new UrlXml();
	}

	@Test
	public void test_url_xml() {
		URL url = urlXml.getUrlXml();
		try {
			System.out.println(url.getPath());
			System.out.println(url.getPort());
			System.out.println(url.getDefaultPort());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_url_baidu() {
		try {
			URL url = urlXml.getBaidu();
			InputStream inputStream = url.openStream();
			InputStreamReader reader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = bufferedReader.readLine();
			while (line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_url_localhost() {
		URL url = urlXml.getLocalhost();
		try {
			if (url == null) {
				return;
			}
			InputStream inputStream = url.openStream();
			InputStreamReader reader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = bufferedReader.readLine();
			while (line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
