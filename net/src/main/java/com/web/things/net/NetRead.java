package com.web.things.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.web.things.util.StringUtil;

/**
 * <pre>
 * 网络资源读取
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月20日
 */
public class NetRead {

	private String urlAddress = "http://www.baidu.com";

	public void read() {
		try {
			URL url = new URL(urlAddress);
			InputStream inputStream = openStream(url);
			InputStreamReader reader = new InputStreamReader(inputStream);
			BufferedReader bufferReader = new BufferedReader(reader);
			String line = bufferReader.readLine();
			StringBuilder result = new StringBuilder();
			String newLine = StringUtil.getNewLine();
			while(line != null) {
				result.append(line).append(newLine);
				line = bufferReader.readLine();
			}
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <pre>
	 * 获取此 URL 的授权部分
	 * 例如：URL地址为http://www.baidu.com，则返回值为www.baidu.com
	 * </pre>
	 * 
	 * @param url
	 * @return
	 */
	public String getAuthority(URL url) {
		return url.getAuthority();
	}

	/**
	 * <pre>
	 * 获取此 URL 的内容
	 * 1、需要进行网络链接之后，才能获取内容，例如url.openConnection().connect()之后
	 * 2、返回的对象为 数据流
	 * </pre>
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public Object getContent(URL url) throws IOException {
		url.openConnection().connect();
		return url.getContent();
	}

	/**
	 * 获取与此 URL 关联协议的默认端口号
	 * 
	 * @param url
	 * @return
	 */
	public int getDefaultPort(URL url) {
		return url.getDefaultPort();
	}

	/**
	 * 获取此 URL 的路径部分
	 * 
	 * @param url
	 * @return
	 */
	public String getPath(URL url) {
		return url.getPath();
	}

	/**
	 * 获取此 URL 的协议名称（例如：http、https、ftp等）
	 * 
	 * @param url
	 * @return
	 */
	public String getProtocol(URL url) {
		return url.getProtocol();
	}

	/**
	 * 获取此 URL 的文件名（用于URL指向一个文件地址时）
	 * 
	 * @param url
	 * @return
	 */
	public String getFile(URL url) {
		return url.getFile();
	}

	/**
	 * 打开到此 URL 的连接并返回一个用于从该连接读入的 InputStream
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public InputStream openStream(URL url) throws IOException {
		return url.openStream();
	}

	public static void main(String[] args) {
		NetRead read = new NetRead();
		read.read();
	}

}
