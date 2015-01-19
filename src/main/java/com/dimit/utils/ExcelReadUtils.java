package com.dimit.utils;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.util.StringUtils;

import com.dimit.excel.config.CellData;
import com.dimit.excel.config.RowData;

/**
 * Dimit 2015年1月18日
 * Excel读取工具
 */
public class ExcelReadUtils {
	/** 第一个数据行*/
	public static final int FIRST_DATA_ROW = 1;
	/** 每行的第一个数据单元格*/
	public static final int ROW_FIRST_DATA = 1;
	/** 第一行*/
	public static final int FIRST_ROW = 0;
	/** 行首个单元格索引*/
	public static final int ROW_FIRST_CELL = 0;
	/** 空字符串*/
	public static final String EMPTY_STR = "";
	/**
	 * 获取每行首个单元格内容
	 * @param row
	 * @return
	 */
	public static String getRowFirstCell(Row row) {
		return row.getCell(ROW_FIRST_CELL).getStringCellValue();
	}
	
	/**
	 * 获取首个数据行
	 * @param sheet
	 * @return
	 */
	public static Row getFirstDataRow(Sheet sheet) {
		return sheet.getRow(FIRST_DATA_ROW);
	}
	
	/**
	 * 获取表空间指定行
	 * @param sheet
	 * @param index
	 * @return
	 */
	public static Row getRowByIndex(Sheet sheet, int index) {
		return sheet.getRow(index);
	}
	
	/**
	 * 获取某一行的真实列数
	 * @param row
	 * @return
	 */
	public static int getCellAmount(Row row) {
		int index = 1;
		while (row.getCell(index)!= null && StringUtils.hasText(row.getCell(index).getStringCellValue())) {
			index++;
		}
		return index-1;
	}
	
	/**
	 * 获取指定单元格字符串值
	 * @param row
	 * @param index
	 * @return
	 */
	public static String getCellStrByIndex(Row row , int index) {
		return row.getCell(index).getStringCellValue();
	}
	
	/**
	 * 获取指定单元格cell对象
	 * @param row
	 * @param index
	 * @return
	 */
	public static Cell getCellByIndex(Row row , int index) {
		return row.getCell(index);
	}
	
	/**
	 * 读取一行数据到缓存中
	 * @param areaData 缓存对象
	 * @param rowData 行数据
	 * @param row {@link Row}
	 */
	public static void readRowData (List<RowData> areaData ,RowData rowData , Row row) {
		for(int j = ROW_FIRST_DATA;j <= rowData.getCellCount() ; j ++) {
			Cell cell = ExcelReadUtils.getCellByIndex(row, j);
			if(ExcelReadUtils.isNull(cell)) {
				break;
			}
			String val = cell.toString();
			rowData.addData(CellData.valueOf(j, val));
		}
		areaData.add(rowData);
	}
	/**
	 * 判断对象是否为空
	 * @param o
	 * @return
	 */
	public static boolean isNull(Object o ) {
		if(o == null) {
			return true;
		}
		return false;
	}
	
}

