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
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy proxy) throws Throwable {
		System.out.println(arg0.getClass().getName() + "--"+arg1.getName() + "增强处理中。。。");
//		return proxy.invoke(arg0, arg2);
		return null;
	}

}

