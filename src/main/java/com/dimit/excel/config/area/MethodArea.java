package com.dimit.excel.config.area;

import org.apache.poi.ss.usermodel.Sheet;

import com.dimit.excel.config.ExcelConfig;
import com.dimit.excel.config.inter.StrDataReader;

/**
 * Dimit 2015年1月19日
 * 测试类方法区域
 */
public class MethodArea implements StrDataReader{

	@Override
	public void init(Sheet sheet , ExcelConfig config) {
		
	}

	@Override
	public String getRowColVal(int row, int col) {
		return null;
	}
	
}

