package com.dimit.schema;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import com.dimit.classLoad.ClassLoaderServiceImpl;

/**
 * Dimit 2015年1月17日
 */
public class ConfigDefinitionParse extends AbstractBeanDefinitionParser {
	@Override
	protected AbstractBeanDefinition parseInternal(Element element,
			ParserContext parserContext) {
		String openAttrStr = element.getAttribute(SchemaName.CONFIG_OPEN_ATTR);
		boolean openAttr = Boolean.valueOf(openAttrStr);
		// 判断是否开启一键测试功能
		if (!openAttr) {
			System.out.println("未开启一键测试功能");
			return null;
		}
		register(parserContext);
		return null;
	}

	/**
	 * 向spring容器注册测试类加载服务对象
	 * 
	 * @param parserContext
	 */
	private void register(ParserContext parserContext) {
		BeanDefinitionRegistry registry = parserContext.getRegistry();
		String name = StringUtils.uncapitalize(ClassLoaderServiceImpl.class
				.getSimpleName());
		BeanDefinitionBuilder factory = BeanDefinitionBuilder
				.rootBeanDefinition(ClassLoaderServiceImpl.class);
		registry.registerBeanDefinition(name, factory.getBeanDefinition());
	}

}
