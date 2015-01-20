package com.dimit.service.convert;

import java.util.HashMap;
import java.util.Map;

import com.dimit.excel.config.inter.SheetStaticName;

/**
 * Dimit 2015年1月20日
 * 
 * 转换器类型
 */
public enum ConvertorType {
	/** 类对象数据转换器*/
	CLZCONVERTOR(SheetStaticName.TEST_CLZ_PREFIX),
	/** 对象数据转换器 */
	OBJECTCONVERTOR(SheetStaticName.OBJ_PREFIX),
	/** 方法数据转换器 */
	METHODCONVERTOR(SheetStaticName.MTD_PREFIX),
	/** map数据转换器 */
	MAPCONVERTOR(SheetStaticName.MAP_FREFIX),
	/** 一般集合转换器 */
	COLLCONVERTOR(SheetStaticName.COLL_PREFIX);

	/** 转换器的配置前缀名 */
	private String configPrefix;
	private static Map<String, ConvertorType> cache = new HashMap<String, ConvertorType>(
			ConvertorType.values().length);
	static {
		cache.put(SheetStaticName.TEST_CLZ_PREFIX, ConvertorType.CLZCONVERTOR);
		cache.put(SheetStaticName.OBJ_PREFIX, ConvertorType.OBJECTCONVERTOR);
		cache.put(SheetStaticName.MTD_PREFIX, ConvertorType.METHODCONVERTOR);
		cache.put(SheetStaticName.MAP_FREFIX, ConvertorType.MAPCONVERTOR);
		cache.put(SheetStaticName.COLL_PREFIX, ConvertorType.COLLCONVERTOR);
	}

	private ConvertorType(String configPrefix) {
		this.configPrefix = configPrefix;
	}
	public String getConfigPrefix() {
		return configPrefix;
	}
	
	public static ConvertorType getConvertType(String configPrefix) {
		return cache.get(configPrefix);
	}
}
