package com.dimit.classLoad.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Dimit 2015年1月19日
 * 测试类增强处理类
 */
public class TestEnhance implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		return null;
	}

}

