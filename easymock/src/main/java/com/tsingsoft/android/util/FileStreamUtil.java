package com.tsingsoft.android.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * <pre>
 * 文件输入or输出流的工具类
 * </pre>
 * 
 * @author songjz
 * @time 2013-12-9
 */
public class FileStreamUtil {
	/**
	 * 关闭OutputStream流
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
			}
		}
	}

	/**
	 * 关闭InputStream流
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
			}
		}
	}

	/**
	 * 关闭Reader流
	 * 
	 * @param streams
	 */
	public static void closeReader(Reader... readers) {
		for (Reader reader : readers) {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 关闭Writer流
	 * 
	 * @param streams
	 */
	public static void closeWriter(Writer... writers) {
		for (Writer writer : writers) {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
			}
		}
	}

}
