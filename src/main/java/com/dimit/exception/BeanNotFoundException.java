package com.dimit.exception;

/**
 * Dimit 2015年1月20日
 * bean未找到异常
 */
public class BeanNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3163015677279787667L;

	public BeanNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeanNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BeanNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BeanNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BeanNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
