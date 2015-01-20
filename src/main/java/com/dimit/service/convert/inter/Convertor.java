package com.dimit.service.convert.inter;

import com.dimit.service.convert.ConvertorType;
import com.dimit.service.convert.MethodContext;

/**
 * Dimit 2015年1月20日
 * 数据转换接口
 */
public interface Convertor {
	/**
	 * 执行转换
	 * @param context 转换方法上下文
	 * @return
	 */
	MethodContext convertor(MethodContext context);
	
	/**
	 * 返回convertor类型
	 * @return
	 */
	ConvertorType getType();	
}

