package com.dimit.service.convert.inter;

import java.lang.reflect.Method;

import com.dimit.excel.config.ExcelConfig;
import com.dimit.service.convert.ConvertorType;
import com.dimit.service.convert.MethodContext;

/**
 * Dimit 2015年1月20日
 * 数据转换接口
 */
public interface Convertor {
	/**
	 * 将配置的字符串参数转换为方法上下文
	 * @param config {@link MethodContext}
	 * @return
	 */
	MethodContext context(ExcelConfig config);
	
	/**
	 * 带方法的转换
	 * @param method
	 * @param config
	 * @return
	 */
	MethodContext context(Method method , ExcelConfig config);
	
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

