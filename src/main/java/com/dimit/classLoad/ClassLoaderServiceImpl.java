package com.dimit.classLoad;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import com.dimit.classLoad.inter.ClassLoaderServiceInter;

/**
 * Dimit 2015年1月17日 加载测试类服务实现类
 */
public class ClassLoaderServiceImpl implements ClassLoaderServiceInter {
	private static final String TESTPATH = "/target/test-classes/";
	private static final String URL_PREFIX = "file:/";

	/** 测试类缓存[测试类名称：测试类] */
	private Map<String, Class<?>> clzMap;

	public ClassLoaderServiceImpl() {
		clzMap = new HashMap<String, Class<?>>();
		init();
	}

	/**
	 * 初始化类加载类
	 */
	public void init() {
		// 开始加载测试类
		loadTestClzs();
	}

	/**
	 * 加载所有测试类构造clzMap
	 */
	@SuppressWarnings("resource")
	private void loadTestClzs() {
		URL[] urls = createUrls();
		URLClassLoader clsLoader = new URLClassLoader(urls);
		try {
			Class<?> clz = clsLoader.loadClass("esayTest.Test2");
			for(Method m :clz.getMethods()) {
				if(m.getName().equals("test")) {
					System.out.println(m.getDeclaredAnnotations().length + "asdjfhja");
					m.invoke(clz.newInstance(), new Object[]{});
				}
			}
			System.out.println(clz.getSimpleName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} 
	}

	/**
	 * 创建加载URL数组
	 * 
	 * @return
	 */
	private URL[] createUrls() {
		String testRoot = URL_PREFIX + System.getProperty("user.dir")
				+ TESTPATH;
		System.out.println(testRoot);
		try {
			return new URL [] {new URL(testRoot)};
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
