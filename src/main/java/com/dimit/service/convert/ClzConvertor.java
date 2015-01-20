package com.dimit.service.convert;

import com.dimit.service.convert.inter.Convertor;

/**
 * Dimit 2015年1月20日
 * 类数据转换器暂时未使用
 */
public class ClzConvertor implements Convertor {

	@Override
	public MethodContext convertor(MethodContext context) {
		return null;
	}

	@Override
	public ConvertorType getType() {
		return ConvertorType.CLZCONVERTOR;
	}

}

