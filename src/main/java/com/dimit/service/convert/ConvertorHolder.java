package com.dimit.service.convert;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.dimit.exception.ConvertorNotFoundException;
import com.dimit.service.convert.inter.Convertor;

/**
 * Dimit 2015年1月20日
 */
@Component
public class ConvertorHolder implements ApplicationContextAware {
	/** convert缓存[convertor类型:Convert实例] */
	private Map<ConvertorType, Convertor> convertorCache = new HashMap<ConvertorType, Convertor>();
	/** spring容器 */
	private ApplicationContext applicationContext;

	@PostConstruct
	private void init() throws Exception {
		for (Convertor convertor : applicationContext.getBeansOfType(
				Convertor.class).values()) {
			Convertor c = convertorCache.put(convertor.getType(), convertor);
			if (c != null) {
				throw new Exception("convertor重复注册");
			}
		}
	}
	
	// 逻辑方法
	/**
	 * 将配置信息转换为方法执行上下文
	 * 
	 * @param m
	 *            执行的方法
	 * @param config
	 *            配置信息对象
	 * @return
	 */
	public MethodContext convert(MethodContext context) {
		context.addHolder(this);
		Convertor methodConvertor = convertorCache.get(ConvertorType.METHODCONVERTOR);
		return methodConvertor.convertor(context);
	}
	
	/**
	 * 根据配置前缀获取转换器
	 * @param prefix 前缀名称 {@link SheetStaticName#TEST_CLZ_PREFIX}
	 * @return
	 */
	public Convertor takeConvertor(String prefix) {
		ConvertorType type = ConvertorType.getConvertType(prefix);
		Convertor convertor = convertorCache.get(type);
		if(convertor == null) {
			throw new ConvertorNotFoundException("指定名称为[" + prefix + "]的数据转换器没有找到");
		}
		return convertor;
	}

	// override方法
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;

	}
}
