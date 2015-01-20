package com.dimit.service.convert;

import com.dimit.service.convert.inter.Convertor;

/**
 * Dimit 2015年1月20日
 * map数据转换器
 */
public class MapConvertor implements Convertor {

	@Override
	public MethodContext convertor(MethodContext context) {
		return null;
	}

	@Override
	public ConvertorType getType() {
		return ConvertorType.MAPCONVERTOR;
	}

}

