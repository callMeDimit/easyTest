package com.dimit.service.convert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.dimit.anno.Test;
import com.dimit.excel.config.ExcelConfig;
import com.dimit.service.convert.inter.Convertor;

/**
 * Dimit 2015年1月20日
 * 方法执行上下文
 */
public class MethodContext {
	/** 方法执行参数*/
	private List<Object> args;
	/** 参数类型数组*/
	private Class<?> [] parameterTypes;
	/** 方法对象*/
	private Method method ;
	/** Test注解*/
	private Test testAnno;
	/** 方法所属类全路径名（包括包名）*/
	private String clzName;
	/** convertor持有对象*/
	private ConvertorHolder convertorHolder;
	/** 静态配置信息对象 */
	private ExcelConfig config;
	
	//逻辑方法
	/**
	 * 增加参数
	 * @param arg
	 */
	public void addArg(Object arg) {
		args.add(arg);
	}
	
	/**
	 * 获取参数个数
	 * @return
	 */
	public int argCount() {
		return parameterTypes.length;
	}
	
	/**
	 * 增加转换器持有对象
	 * @param holder
	 */
	public void addHolder(ConvertorHolder holder) {
		this.convertorHolder = holder;
	}
	
	/**
	 * 通过装换器前缀获取转换器对象
	 * @param converterPrefix
	 * @return
	 */
	public Convertor takeConvertor(String converterPrefix) {
		return convertorHolder.takeConvertor(converterPrefix);
	}
	
	//---getter
	/**
	 * @return the args
	 */
	public List<Object> getArgs() {
		return args;
	}
	
	/**
	 * @return the config
	 */
	public ExcelConfig getConfig() {
		return config;
	}

	/**
	 * @return the parameterTypes
	 */
	public Class<?>[] getParameterTypes() {
		return parameterTypes;
	}

	/**
	 * @return the method
	 */
	public Method getMethod() {
		return method;
	}

	/**
	 * @return the testAnno
	 */
	public Test getTestAnno() {
		return testAnno;
	}

	/**
	 * @return the clzName
	 */
	public String getClzName() {
		return clzName;
	}

	//valueOf 
	/**
	 * @param m 方法对象
	 * @param config 配置信息对象
	 * @param testAnno Test注解
	 * @return
	 */
	public static MethodContext valueOf(Method m, ExcelConfig config , Test testAnno , String clzName) {
		MethodContext context = new MethodContext();
		context.method = m;
		context.config = config;
		context.testAnno = testAnno;
		context.parameterTypes = m.getParameterTypes();
		context.args = new ArrayList<Object> (context.parameterTypes.length);
		context.clzName = clzName;
		return context;
	}
	/**
	 * @param m 方法对象
	 * @param clzName 类名
	 * @return
	 */
	public static MethodContext valueOf(String clzName) {
		MethodContext context = new MethodContext();
		context.clzName = clzName;
		return context;
	}
}

