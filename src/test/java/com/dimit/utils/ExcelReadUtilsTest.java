package com.dimit.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Dimit 2015年1月19日
 */
public class ExcelReadUtilsTest {
	private static Workbook wb;
	@BeforeClass
	public static void beforeClz() {
		try {
			InputStream input = new FileInputStream(new File(
					"C:/Users/gzeyu/Desktop/test3.xls"));
			wb = new HSSFWorkbook(input);
		} catch (Exception e) {
		}
	}

	@Test
	public void getCellAmountTest() {
		Sheet s = wb.getSheet("testClz");
		int rel = ExcelReadUtils.getCellAmount(s.getRow(0));
		System.out.println(rel);
	}
	

	@Test
	public void initTest() {
		Sheet s = wb.getSheet("testClz");
		
	}

}

