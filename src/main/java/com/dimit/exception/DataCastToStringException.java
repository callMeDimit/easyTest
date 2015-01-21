package com.dimit.exception;
/**
 * Dimit 2015年1月21日
 * 数据转换为字符串异常
 */
public class DataCastToStringException extends MustHandleException {

	private static final long serialVersionUID = -3088140941819309215L;

	public DataCastToStringException() {
		super();
	}

	public DataCastToStringException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DataCastToStringException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataCastToStringException(String message) {
		super(message);
	}

	public DataCastToStringException(Throwable cause) {
		super(cause);
	}
}

