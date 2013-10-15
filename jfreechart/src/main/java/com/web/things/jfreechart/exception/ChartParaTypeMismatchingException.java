package com.web.things.jfreechart.exception;

/**
 * <pre>
 * 图形参数类型不匹配异常
 * </pre>
 * 
 * @author songjz
 * @time 2013年8月2日
 */
public class ChartParaTypeMismatchingException extends RuntimeException {

	private static final long serialVersionUID = 3336748105924888648L;

	public ChartParaTypeMismatchingException() {
		super();
	}

	public ChartParaTypeMismatchingException(String message) {
		super(message);
	}

	public ChartParaTypeMismatchingException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChartParaTypeMismatchingException(Throwable cause) {
		super(cause);
	}
}
