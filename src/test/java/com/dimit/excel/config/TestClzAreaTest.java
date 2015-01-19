package com.dimit.excel.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dimit.excel.config.area.TestClzArea;

/**
 * Dimit 2015年1月19日
 */
public class TestClzAreaTest {
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
}

