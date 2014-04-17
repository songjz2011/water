/*
 * SearchException.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.exception;

/**
 * <pre>
 * 查询数据异常
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月10日
 */
public class SearchException extends RuntimeException {

	private static final long serialVersionUID = -3629381444479912019L;

	public SearchException() {
	}

	public SearchException(String detailMessage) {
		super(detailMessage);
	}

	public SearchException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public SearchException(Throwable throwable) {
		super(throwable);
	}

}
