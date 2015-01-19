package com.dimit.classLoad.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Dimit 2015年1月19日
 * 测试类代理工厂
 */
public class TestProxyFactory {
	
	/**
	 * 获取测试类代理对象
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getTestProxy(Class<T> c , TestEnhance testEnhance) {
		Enhancer en = new Enhancer();
		en.setSuperclass(c);
		en.setCallback(testEnhance);
		return (T) en.create();
	}
}

