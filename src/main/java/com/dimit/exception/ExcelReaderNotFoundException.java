package com.dimit.exception;


/**
 * Dimit 2015年1月19日
 * excel读取器未找到异常
 */
public class ExcelReaderNotFoundException extends ExcelException {
	private static final long serialVersionUID = -2309065131363632216L;

	public ExcelReaderNotFoundException() {
		super();
	}

	public ExcelReaderNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcelReaderNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcelReaderNotFoundException(String message) {
		super(message);
	}

	public ExcelReaderNotFoundException(Throwable cause) {
		super(cause);
	}

	
	
}

