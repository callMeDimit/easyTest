package com.dimit.excel.config;

import com.dimit.excel.config.inter.SheetStaticName;

/**
 * Dimit 2015年1月18日
 * 配置信息类型
 */
public enum ConfigType {
	/** 测试类*/
	TEST_CLASS(SheetStaticName.TESTCLASS,SheetStaticName.TESTCLASSNAME),
	/** 测试方法*/
	TEST_METOD(SheetStaticName.METHOD,SheetStaticName.METHODNAME),
	/** map配置信息*/
	MAP(SheetStaticName.MAP,SheetStaticName.MAPNAME),
	/** 集合*/
	COLLECTION(SheetStaticName.COLLECTION,SheetStaticName.COLLECTIONNAME),
	/** 数据*/
	OBJECT(SheetStaticName.OBJECT,SheetStaticName.OBJECTNAME);
	/**表空间名称*/
	private String sheetName;
	/** 存储类全名*/
	private String clzName;
	private ConfigType (String sheetName,String clzName) {
		this.sheetName = sheetName;
		this.clzName = clzName;
	}
	//getter 
	/**
	 * @return the sheetName
	 */
	public String getSheetName() {
		return sheetName;
	}
	/**
	 * @return the clzName
	 */
	public String getClzName() {
		return clzName;
	}
}
