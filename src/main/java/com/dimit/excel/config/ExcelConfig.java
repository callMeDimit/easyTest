package com.dimit.excel.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.dimit.excel.config.area.CollectionArea;
import com.dimit.excel.config.area.MapArea;
import com.dimit.excel.config.area.MethodArea;
import com.dimit.excel.config.area.ObjectArea;
import com.dimit.excel.config.area.TestClzArea;
import com.dimit.excel.config.inter.StrDataReader;
import com.dimit.exception.ExcelReaderNotFoundException;

/**
 * Dimit 2015年1月18日
 * 配置文件全局对象
 */
public class ExcelConfig {
	
	private Format format;
	/** 测试类区域数据*/
	private TestClzArea testClzArea;
	/** 方法数据区*/
	private MethodArea methodArea;
	/** 对象数据区*/
	private ObjectArea objectArea;
	/** map区*/
	private MapArea mapArea;
	/** 一般集合区*/
	private CollectionArea collArea;
	
	//逻辑方法
	/**
	 * 初始化配置excel配置文件对象
	 */
	public void init() {
		try {
			InputStream input = new FileInputStream(new File(format.getLocation()));
			Workbook wb = new HSSFWorkbook(input);
			//遍历读取所有sheet空间
			for(ConfigType type : ConfigType.values()) {
				Sheet sheet = wb.getSheet(type.getSheetName());
				creatCache(sheet,type.getClzName());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 创建缓存
	 * @param sheet
	 * @param clzName
	 */
	private void creatCache(Sheet sheet, String clzName) {
		StrDataReader reader = StrDataReaderFactory.getReader(clzName);
		if(reader == null) {
			throw new ExcelReaderNotFoundException("未找到"+ clzName + "excel读取器");
		}
		reader.init(sheet,this);
	}
	
	// getter

	/**
	 * @return the testClzArea
	 */
	public TestClzArea getTestClzArea() {
		return testClzArea;
	}

	/**
	 * @return the methodArea
	 */
	public MethodArea getMethodArea() {
		return methodArea;
	}

	/**
	 * @return the objectArea
	 */
	public ObjectArea getObjectArea() {
		return objectArea;
	}

	/**
	 * @return the mapArea
	 */
	public MapArea getMapArea() {
		return mapArea;
	}

	/**
	 * @return the collArea
	 */
	public CollectionArea getCollArea() {
		return collArea;
	}
	// setter
	/**
	 * @param testClzArea the testClzArea to set
	 */
	public void setTestClzArea(TestClzArea testClzArea) {
		this.testClzArea = testClzArea;
	}

	/**
	 * @param methodArea the methodArea to set
	 */
	public void setMethodArea(MethodArea methodArea) {
		this.methodArea = methodArea;
	}

	/**
	 * @param objectArea the objectArea to set
	 */
	public void setObjectArea(ObjectArea objectArea) {
		this.objectArea = objectArea;
	}

	/**
	 * @param mapArea the mapArea to set
	 */
	public void setMapArea(MapArea mapArea) {
		this.mapArea = mapArea;
	}

	/**
	 * @param collArea the collArea to set
	 */
	public void setCollArea(CollectionArea collArea) {
		this.collArea = collArea;
	}

	//valueOf
	public static ExcelConfig valueOf(Format format) {
		ExcelConfig config = new ExcelConfig();
		config.format = format;
		return config;
	}
}
