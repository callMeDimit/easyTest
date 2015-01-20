package com.dimit.exception;
/**
 * Dimit 2015年1月20日
 * 转换器没有找到异常
 */
public class ConvertorNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5677593302709640569L;

	public ConvertorNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConvertorNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ConvertorNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ConvertorNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ConvertorNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}

