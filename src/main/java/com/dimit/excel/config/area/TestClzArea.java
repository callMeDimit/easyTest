package com.dimit.excel.config.area;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.dimit.excel.config.ExcelConfig;
import com.dimit.excel.config.RowData;
import com.dimit.excel.config.inter.SheetStaticName;
import com.dimit.excel.config.inter.StrDataReader;
import com.dimit.utils.ExcelReadUtils;

/**
 * Dimit 2015年1月18日
 *	测试类区域
 */
public class TestClzArea implements StrDataReader{
	/** 本区域内的所有数据*/
	List<RowData> areaData = new ArrayList<RowData>();
	//逻辑方法
	@Override
	public void init(Sheet sheet , ExcelConfig config) {
		for(int i = ExcelReadUtils.FIRST_DATA_ROW;i<sheet.getLastRowNum();i++) {
			int cellCount = ExcelReadUtils.getCellAmount(sheet.getRow(ExcelReadUtils.FIRST_ROW));
			Row row = ExcelReadUtils.getRowByIndex(sheet, i);
			Cell firestCell = row.getCell(ExcelReadUtils.ROW_FIRST_CELL);
			RowData rowData = RowData.valueOf(i,cellCount);
			//如果是结束标识
			if(!ExcelReadUtils.isNull(firestCell) && 
					firestCell.getStringCellValue().equalsIgnoreCase(SheetStaticName.END)) {
				ExcelReadUtils.readRowData(areaData, rowData, row);
				break;
			} else {
				ExcelReadUtils.readRowData(areaData, rowData, row);
			}
		}
		config.setTestClzArea(this);
	}
	
	/**
	 * 取得指定行号和列好数据
	 * @param row
	 * @param col
	 * @return
	 */
	public String getRowColVal(int row,int col) {
		return areaData.get(row).takeCol(col);
	}
	
	//valueOf
	public static TestClzArea valueOf() {
		TestClzArea testClz = new TestClzArea();
		return testClz;
	}
}

