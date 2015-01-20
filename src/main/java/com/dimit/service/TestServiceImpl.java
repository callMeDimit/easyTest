package com.dimit.service;

import java.lang.reflect.Method;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.dimit.anno.Test;
import com.dimit.classLoad.service.ClassLoaderServiceImpl;
import com.dimit.excel.service.ExcelServiceImpl;
import com.dimit.exception.BeanNotFoundException;
import com.dimit.service.convert.ConvertorHolder;
import com.dimit.service.convert.MethodContext;

/**
 * Dimit 2015年1月20日
 * 容器刷新完成后开始执行
 */
@Component("testServiceImpl")
public class TestServiceImpl implements ApplicationContextAware,ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private ClassLoaderServiceImpl classLoaderService;
	@Autowired
	private ExcelServiceImpl excelServiceImpl;
	@Autowired
	private ConvertorHolder convertHolder;
	private ApplicationContext applicationContext;
	
	//逻辑方法
	/**
	 * 执行测试类的所有测试方法
	 * @param bean 测试类
	 */
	private void executTest(Object bean) {
		Class <?> clz = bean.getClass();
		Method [] methods =clz.getDeclaredMethods();
		for(Method m : methods) {
			//若没有Test注解直接返回
			Test t = m.getAnnotation(Test.class);
			if(t == null) {
				continue;
			}
			//准备执行上下文
			MethodContext context = prepareArg(m , t , clz.getName());
			startTest(context);
		}
	}
	
	/**
	 * 准备执行上下文
	 * 
	 * @param m
	 * @return MethodContext 方法执行上下文
	 */
	private MethodContext prepareArg(Method m, Test testAnno, String clzName) {
		MethodContext context = MethodContext.valueOf(m,
				excelServiceImpl.getExcelConfig(), testAnno, clzName);
		return convertHolder.convert(context);
	}
	
	/**
	 * 开始执行测试
	 * @param context
	 */
	private void startTest(MethodContext context) {
		
	}


	//override 方法
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//拿到所有需要测试类的beanName集合
		Set<String> beanNames = classLoaderService.getBeanNameCache();
		for(String name : beanNames) {
			Object bean = applicationContext.getBean(name);
			//如果bean为空
			if(bean == null) {
				throw new BeanNotFoundException("在容器中未找到["+name+"]的定义。请检查该类名bean是否进行注册");
			}
			executTest(bean);
		}
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
}

