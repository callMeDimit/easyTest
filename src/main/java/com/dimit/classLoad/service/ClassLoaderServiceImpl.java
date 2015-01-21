package com.dimit.classLoad.service;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

import com.dimit.anno.Ignore;
import com.dimit.classLoad.TestClzInfo;
import com.dimit.classLoad.service.inter.ClassLoaderServiceInter;

/**
 * Dimit 2015年1月17日 加载测试类服务实现类
 */
public class ClassLoaderServiceImpl implements ClassLoaderServiceInter {
	/** 测试.class相对根路径 */
	private static final String TEST_PATH = "/target/test-classes/";
	/** url 前缀 */
	private static final String URL_PREFIX = "file:/";
	/** 类文件后缀*/
	public static final String CLZ_SUFFIX = ".class";
	/** 项目根路径 */
	private static final String USER_DIR = "user.dir";
	/** 文件分隔符*/
	private static final String SEPARATE = "/";
	/** 测试包全路径 */
	public static final String TEST_ROOT_PATH = System.getProperty(USER_DIR)
			+ TEST_PATH;

	private BeanDefinitionRegistry registry;
	/** 测试类beanName缓存*/
	private Set<String> beanNameCache;
	
	/** 测试类加载器*/
	private URLClassLoader clsLoader;

	public ClassLoaderServiceImpl( BeanDefinitionRegistry registry) {
		this.registry = registry;
		this.beanNameCache = new HashSet<String>();
		// 构建ClassLoader
		clsLoader = new URLClassLoader(createUrls());
		init();
	}

	/**
	 * 初始化类加载类
	 */
	public void init() {
		File rootFile = new File(TEST_ROOT_PATH);
		//开始递归构建缓存对象
		recursive(rootFile);
	}

	/**
	 * 加载所有测试类构造clzMap
	 */
	private void loadTestClz(TestClzInfo info) {
		try {
			Class<?> clz = clsLoader.loadClass(info.getFullPath());
			// 检查是否该类需要忽略
			Ignore ignore = clz.getAnnotation(Ignore.class);
			if (ignore != null) {
				return;
			}
			String beanName = clz.getName();
			//向容器注入测试类
			regTestClz(beanName, clz);
			//缓存测试类beanName
			beanNameCache.add(beanName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}

	/**
	 * 创建加载URL数组
	 * 
	 * @return
	 */
	private URL[] createUrls() {
		try {
			return new URL[] { new URL(URL_PREFIX + TEST_ROOT_PATH) };
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 递归构造测试路径下所有Class对象
	 * 
	 * @param clzMap
	 */
	private void recursive(File file) {
		// 递归跳出条件：如果是file对象所关联的是文件则递归跳出
		if (file.isFile()) {
			String path = file.getPath();
			//如果是类文件
			if(path.endsWith(CLZ_SUFFIX)) {
				TestClzInfo info = TestClzInfo.valueOf(path);
				loadTestClz(info);
			}
			return;
		}
		String[] paths = file.list();
		for (String path : paths) {
			File childFile = new File(file.getPath() + SEPARATE + path + SEPARATE);
			recursive(childFile);
		}
	}
	
	/**
	 * 向容器注册测试类
	 * @param beanName
	 * @param clz
	 */
	private void regTestClz(String beanName , Class<?> clz) {
		BeanDefinitionBuilder factory = BeanDefinitionBuilder
				.rootBeanDefinition(clz);
		registry.registerBeanDefinition(beanName, factory.getBeanDefinition());
	}
	
	// ----getter

	/**
	 * @return the beanNameCache
	 */
	public Set<String> getBeanNameCache() {
		return beanNameCache;
	}
	
}
