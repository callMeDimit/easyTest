package com.dimit.excel.config;
/**
 * Dimit 2015年1月19日
 * 单元格数据
 */
public class CellData {
	/** 单元格值*/
	private String centent;
	/** 单元格所在列*/
	private int cellNumber;
	
	//getter
	/**
	 * @return the centent
	 */
	public String getCentent() {
		return centent;
	}


	/**
	 * @return the cellNumber
	 */
	public int getCellNumber() {
		return cellNumber;
	}


	//valueOf
	/**
	 * 带列值构造函数
	 * @param cellNumber
	 * @return
	 */
	public static CellData valueOf(int cellNumber) {
		CellData cell = new CellData();
		cell.cellNumber = cellNumber;
		return cell;
	}
	
	/**
	 * @param cellNumber
	 * @param centent
	 * @return
	 */
	public static CellData valueOf(int cellNumber,String centent) {
		CellData cell = new CellData();
		cell.cellNumber = cellNumber;
		cell.centent = centent;
		return cell;
	}
}

