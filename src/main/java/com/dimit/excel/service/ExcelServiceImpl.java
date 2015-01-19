package com.dimit.excel.service;

import com.dimit.excel.Format;
import com.dimit.excel.config.ExcelConfig;


/**
 * Dimit 2015年1月18日
 * excel读取服务
 */
public class ExcelServiceImpl {
	public static final String FORMAT_FIELD = "format";
	/** excel文件信息*/
	private ExcelConfig excelConfig;
	
	//构造函数
	public ExcelServiceImpl() {
	}
	
	public ExcelServiceImpl(Format format) {
		this.excelConfig = ExcelConfig.valueOf(format);
		init();
	}

	//逻辑方法
	/**
	 * 初始化方法
	 */
	private void init() {
		//初始化excel配置信息
		excelConfig.init();
	}
}

