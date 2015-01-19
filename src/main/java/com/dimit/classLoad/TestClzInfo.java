package com.dimit.classLoad;

import org.springframework.util.StringUtils;

import com.dimit.classLoad.service.ClassLoaderServiceImpl;


/**
 * Dimit 2015年1月18日
 * 测试类信息
 */
public class TestClzInfo {
	private static final String SEPARATE = "\\";
	private static final String POINT = ".";
	/**测试类所在路径*/
	private String path;
	/** 全路径*/
	private String fullPath ;
	
	//私有逻辑方法
	/**
	 * 将文件路径转换包名
	 * @param path
	 * @return
	 */
	private String convertToPackage(String path) {
		String fullClzName = path.substring(ClassLoaderServiceImpl.TEST_ROOT_PATH.length(),path.length()-ClassLoaderServiceImpl.CLZ_SUFFIX.length());
		return StringUtils.replace(fullClzName, SEPARATE, POINT);
	}
	
	//getters
	public String getPath() {
		return path;
	}
	public String getFullPath() {
		return fullPath;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestClzInfo [path=" + path + ", fullPath=" + fullPath
				+ "]";
	}

	//valueof method
	/**
	 * 构造方法
	 * @param path 测试类真实路径
	 * @param packageName 测试类包名
	 * @return
	 */
	public static TestClzInfo valueOf(String path,String packageName) {
		TestClzInfo info = new TestClzInfo();
		info.path = path;
		info.fullPath = packageName;
		return info;
	}
	
	
	public static TestClzInfo valueOf(String path) {
		TestClzInfo info = new TestClzInfo();
		info.path = path;
		info.fullPath = info.convertToPackage(path);
		return info;
	}
}

