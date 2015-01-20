package com.dimit.exception;
/**
 * Dimit 2015年1月20日
 * 所有必需捕获的异常基类
 */
public class MustHandleException extends Exception {

	private static final long serialVersionUID = -1118805154458244458L;

	public MustHandleException() {
		super();
	}

	public MustHandleException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MustHandleException(String message, Throwable cause) {
		super(message, cause);
	}

	public MustHandleException(String message) {
		super(message);
	}

	public MustHandleException(Throwable cause) {
		super(cause);
	}
	
}

