package com.dimit.exception;

/**
 * Dimit 2015年1月20日 所有必需捕获的异常基类
 */
public class MustHandleException extends Exception {

	private static final long serialVersionUID = -1118805154458244458L;

	/** 错误出现的行号 */
	private int rowNumber;
	/** 错误出现的列号 */
	private int cellNumber;
	/** 输出行号 */
	private int outputRow;
	/** 输出的列号 */
	private int outputCell;

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

	public MustHandleException(String message, int rowNumber, int cellNumber,
			int outputRow, int outputCell) {
		super(message);
		this.rowNumber = rowNumber;
		this.cellNumber = cellNumber;
		this.outputRow = outputRow;
		this.outputCell = outputCell;
	}

	// ----getter

	/**
	 * @return the rowNumber
	 */
	public int getRowNumber() {
		return rowNumber;
	}

	/**
	 * @return the cellNumber
	 */
	public int getCellNumber() {
		return cellNumber;
	}

	/**
	 * @return the outputRow
	 */
	public int getOutputRow() {
		return outputRow;
	}

	/**
	 * @return the outputCell
	 */
	public int getOutputCell() {
		return outputCell;
	}
}
