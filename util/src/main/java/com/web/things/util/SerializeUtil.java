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
			closeOutputStream(objectStream, byteStream);
		}
		return result;
	}

	/**
	 * 反序列化成对象
	 * 
	 * @param buf
	 * @return
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
			closeInputStream(objectStream, byteStream);
		}
		return result;
	}

	/**
	 * 关闭输出流
	 * 
	 * @param streams
	 */
	private static void closeOutputStream(OutputStream... streams) {
		for (OutputStream stream : streams) {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (IOException e) {
				LoggerUtil.error(SerializeUtil.class, e.getMessage());
			}
		}
	}

	/**
	 * 关闭输入流
	 * 
	 * @param streams
	 */
	private static void closeInputStream(InputStream... streams) {
		for (InputStream stream : streams) {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (IOException e) {
				LoggerUtil.error(SerializeUtil.class, e.getMessage());
			}
		}
	}

}
