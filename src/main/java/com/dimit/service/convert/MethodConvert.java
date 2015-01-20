package com.dimit.service.convert;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

import com.dimit.excel.config.ExcelConfig;

/**
 * Dimit 2015年1月20日
 * 方法数据转换
 */
@Component
public class MethodConvert extends AbstractConvertor{

	@Override
	public MethodContext context(Method m ,ExcelConfig config) {
		return null;
	}

	@Override
	public ConvertorType getType() {
		return ConvertorType.METHODCONVERTOR;
	}

	@Override
	public MethodContext convertor(MethodContext context) {
		return null;
	}
}
