package com.web.things.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <pre>
 * 文件输入or输出流的工具类
 * </pre>
 * 
 * @author songjz
 * @time 2013年11月15日
 */
public class FileStreamUtil {
	/**
	 * 关闭输出流
	 * 
	 * @param streams
	 */
	public static void closeOutputStream(OutputStream... streams) {
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
	public static void closeInputStream(InputStream... streams) {
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
