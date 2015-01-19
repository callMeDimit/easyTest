package com.dimit.excel.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Dimit 2015年1月19日
 * 行数据对象
 */
public class RowData {
	/**行号*/
	private int rowNumber;
	/** 本行有效单元格数*/
	private int cellCount;
	/** 列数据集合*/
	List<CellData> list = new ArrayList<CellData>();

	/**
	 * 增加一个数据
	 * @param str
	 */
	public void addData(CellData cell) {
		list.add(cell);
	}
	
	/**
	 * 取得指定列数据
	 * @param col
	 * @return
	 */
	public String takeCol(int col) {
		return list.get(col).getCentent();
	}
	
	//getter
	
	/**
	 * @return the rowNumber
	 */
	public int getRowNumber() {
		return rowNumber;
	}
	
	/**
	 * @return the cellCount
	 */
	public int getCellCount() {
		return cellCount;
	}
	
	//valueOf
	
	/**
	 * 
	 * @param rowNumber
	 * @return
	 */
	public static RowData valueOf(int rowNumber) {
		RowData rowData = new RowData();
		rowData.rowNumber = rowNumber;
		return rowData;
	}
	/**
	 * @param rowNumber
	 * @param cellCount
	 * @return
	 */
	public static RowData valueOf(int rowNumber , int cellCount) {
		RowData rowData = new RowData();
		rowData.rowNumber = rowNumber;
		rowData.cellCount = cellCount;
		return rowData;
	}
}

