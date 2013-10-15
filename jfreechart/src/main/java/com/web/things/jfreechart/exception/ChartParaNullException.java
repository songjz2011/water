package com.web.things.jfreechart.exception;

/**
 * <pre>
 * ChartParameter为null的异常
 * </pre>
 * 
 * @author songjz
 * @time 2013年8月1日
 */
public class ChartParaNullException extends NullPointerException {

	private static final long serialVersionUID = 6791762476032503794L;

	public ChartParaNullException() {
		super();
	}

	public ChartParaNullException(String s) {
		super(s);
	}

}
