package com.dimit.excel.config.inter;

import org.apache.poi.ss.usermodel.Sheet;

import com.dimit.excel.config.ExcelConfig;
import com.dimit.exception.DataCastToStringException;

/**
 * Dimit 2015年1月19日
 * excel字符串数据读取
 */
public interface StrDataReader {
	/** 其实行*/
	int FIRST_ROW_NUMBER = 1;
	/** 起始列*/
	int FIRST_CELL_NUMBER = 0;
	/**
	 * 初始化方法
	 * @param sheet
	 */
	void init(Sheet sheet, ExcelConfig config) throws DataCastToStringException;
}

