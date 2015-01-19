package com.dimit.excel.config;

import org.springframework.util.StringUtils;

import com.dimit.excel.config.inter.StrDataReader;

/**
 * Dimit 2015年1月19日
 * excel静态字符串数据读取器工厂
 */
public class StrDataReaderFactory {
	/**
	 * 根据读取器类全名产生读取器
	 * @param clzName
	 * @return
	 */
	public static StrDataReader getReader(String clzName) {
		try {
			if(StringUtils.hasText(clzName)) {
				//根据clzName构建具体的读取器对
				Class<?> clz = Class.forName(clzName);
				return (StrDataReader) clz.newInstance();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}

