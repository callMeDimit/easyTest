package com.dimit.service.convert;

import java.lang.reflect.Method;

import com.dimit.excel.config.ExcelConfig;
import com.dimit.service.convert.inter.Convertor;

/**
 * Dimit 2015年1月20日
 */
public abstract class AbstractConvertor implements Convertor {

	@Override
	public MethodContext context(ExcelConfig config) {
		return null;
	}

	@Override
	public MethodContext context(Method method, ExcelConfig config) {
		return null;
	}

}

