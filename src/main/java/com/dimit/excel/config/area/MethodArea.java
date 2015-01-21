package com.dimit.excel.config.area;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.dimit.excel.config.ExcelConfig;
import com.dimit.excel.config.RowData;
import com.dimit.excel.config.inter.StrDataReader;
import com.dimit.exception.DataCastToStringException;
import com.dimit.utils.ExcelReadUtils;

/**
 * Dimit 2015年1月19日
 * 测试类方法区域
 */
public class MethodArea implements StrDataReader{
	/** 方法区域配置数据个数*/
	public static int MTD_AREA_LENGTH = 5;
	
	/** 数据缓存[类全名:[方法名:方法数据]]*/
	private Map<String,Map<String , RowData>> cache = new HashMap<String, Map<String,RowData>>();

	@Override
	public void init(Sheet sheet , ExcelConfig config) throws DataCastToStringException {
		for(int i = ExcelReadUtils.FIRST_ROW;!ExcelReadUtils.isLastRow(sheet, i);i++) {
			Row row = ExcelReadUtils.getRowByIndex(sheet, i);
			for(int j = 0; j < MTD_AREA_LENGTH;j++) {
				Cell cell = row.getCell(j);
				if(cell.getCellType() != Cell.CELL_TYPE_STRING) {
					cell.setCellValue("aaaaa");
				}
				
			}
		}
	}
	
}

