package com.dimit.service.convert;

import org.springframework.stereotype.Component;

import com.dimit.service.convert.inter.Convertor;

/**
 * Dimit 2015年1月20日
 * 方法数据转换
 */
@Component
public class MethodConvert implements Convertor{

	@Override
	public ConvertorType getType() {
		return ConvertorType.METHODCONVERTOR;
	}

	@Override
	public MethodContext convertor(MethodContext context) {
		return null;
	}
}
