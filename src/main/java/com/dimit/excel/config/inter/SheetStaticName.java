package com.dimit.excel.config.inter;

/**
 * Dimit 2015年1月19日 sheet相关静态名称
 */
public interface SheetStaticName {
	/** 测试类sheet名 */
	String TESTCLASS = "testClz";
	/** 测试类区域对应类全名 */
	String TESTCLASSNAME = "com.dimit.excel.config.area.TestClzArea";
	/** 方法sheet名 */
	String METHOD = "method";
	/** 方法区域类全民 */
	String METHODNAME = "com.dimit.excel.config.area.MethodArea";
	/** map sheet名 */
	String MAP = "map";
	/** map区域类全名 */
	String MAPNAME = "com.dimit.excel.config.area.MapArea";
	/** List OR Set sheet名 */
	String COLLECTION = "collection";
	/** 一般集合区域类全名 */
	String COLLECTIONNAME = "com.dimit.excel.config.area.CollectionArea";
	/** 对象 sheet名 */
	String OBJECT = "object";
	/** 对象数据区域名 */
	String OBJECTNAME = "com.dimit.excel.config.area.ObjectArea";
	/** 结束控制 */
	String END = "END";
	/** 配置引用标识 */
	String REFRENCEFLAG = "#";
	/** 测试类配置引用前缀 */
	String TEST_CLZ_PREFIX = "#CLZ";
	/** 方法配置引用前缀 */
	String MTD_PREFIX = "#MTD";
	/** 对象配置引用前缀 */
	String OBJ_PREFIX = "#OBJ";
	/** map配置前缀 */
	String MAP_FREFIX = "#MAP";
	/** 一般集合配置前缀 */
	String COLL_PREFIX = "#COLL";
}
