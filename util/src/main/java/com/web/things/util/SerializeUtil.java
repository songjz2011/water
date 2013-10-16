package com.web.things.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * <pre>
 * 序列化对象工具类
 * </pre>
 * 
 * @author songjz
 * @time 2013年10月16日
 */
public class SerializeUtil {

	/**
	 * 序列化对象
	 * 
	 * @param object
	 * @return
	 * @throws IOException
	 */
	public static byte[] serializeObject(Object object) {
		byte[] result = null;
		ByteArrayOutputStream byteStream = null;
		ObjectOutputStream objectStream = null;
		try {
			byteStream = new ByteArrayOutputStream();
			objectStream = new ObjectOutputStream(byteStream);
			objectStream.writeObject(object);
			objectStream.flush();
			byteStream.flush();
			result = byteStream.toByteArray();
		} catch (Exception e) {
			LoggerUtil.error(SerializeUtil.class, e.getMessage());
		} finally {
			closeOutputStream(objectStream);
			closeOutputStream(byteStream);
		}
		return result;
	}

	/**
	 * 反序列化成对象
	 * 
	 * @param buf
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deSerializeObject(byte[] buf) {
		Object result = null;
		ByteArrayInputStream byteStream = null;
		ObjectInputStream objectStream = null;
		try {
			byteStream = new ByteArrayInputStream(buf);
			objectStream = new ObjectInputStream(byteStream);
			result = objectStream.readObject();
		} catch (Exception e) {
			LoggerUtil.error(SerializeUtil.class, e.getMessage());
		} finally {
			closeInputStream(objectStream);
			closeInputStream(byteStream);
		}
		return result;
	}

	/**
	 * 关闭输出流
	 * 
	 * @param stream
	 */
	private static void closeOutputStream(OutputStream stream) {
		try {
			if (stream != null) {
				stream.close();
			}
		} catch (IOException e) {
			LoggerUtil.error(SerializeUtil.class, e.getMessage());
		}
	}

	/**
	 * 关闭输入流
	 * 
	 * @param stream
	 */
	private static void closeInputStream(InputStream stream) {
		try {
			if (stream != null) {
				stream.close();
			}
		} catch (IOException e) {
			LoggerUtil.error(SerializeUtil.class, e.getMessage());
		}
	}

}
