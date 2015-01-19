package com.dimit.schema;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.dimit.classLoad.service.ClassLoaderServiceImpl;
import com.dimit.excel.Format;
import com.dimit.excel.service.ExcelServiceImpl;

/**
 * Dimit 2015年1月17日
 */
public class ConfigDefinitionParse extends AbstractBeanDefinitionParser {
	@Override
	protected AbstractBeanDefinition parseInternal(Element element,
			ParserContext parserContext) {
		// 判断是否开启一键测试功能
		String openAttrStr = element.getAttribute(SchemaName.CONFIG_OPEN_ATTR);
		boolean openAttr = Boolean.valueOf(openAttrStr);
		if (!openAttr) {
			System.out.println("未开启一键测试功能");
			return null;
		}
		NodeList childs = element.getChildNodes();
		for(int i = 0;i<childs.getLength();i++) {
			Node node = childs.item(i);
			if(!(node instanceof Element)) {
				continue;
			}
			Element e = (Element) node;
			Format format = resolveFormat(e);
			//向容器注册读取excel服务
			registerExcelReader(parserContext,format);
		}
		//向容器注册测试服务
		registTestService(parserContext);
		return null;
	}

	/**
	 * 向spring容器注册读取excel服务类
	 * @param parserContext
	 * @param argument
	 */
	private void registerExcelReader(ParserContext parserContext,Format format) {
		BeanDefinitionRegistry registry = parserContext.getRegistry();
		
		//注册ExcelReaderServiceImpl服务
		String excel = StringUtils.uncapitalize(ExcelServiceImpl.class
				.getSimpleName());
		BeanDefinitionBuilder excelFactory = BeanDefinitionBuilder
				.rootBeanDefinition(ExcelServiceImpl.class);
		excelFactory.addConstructorArgValue(format);
		registry.registerBeanDefinition(excel, excelFactory.getBeanDefinition());
	}
	
	/**
	 * 向容器注册测试服务
	 * @param parserContext
	 */
	private void registTestService(ParserContext parserContext) {
		BeanDefinitionRegistry registry = parserContext.getRegistry();
		//注册ClassLoaderServiceImpl类加载服务
		String name = StringUtils.uncapitalize(ClassLoaderServiceImpl.class
				.getSimpleName());
		BeanDefinitionBuilder factory = BeanDefinitionBuilder
				.rootBeanDefinition(ClassLoaderServiceImpl.class);
		
		//将读取的静态excel数据服务对象注入类加载服务对象中
		if(registry instanceof BeanFactory) {
			BeanFactory beanFactory = (BeanFactory) registry;
			ExcelServiceImpl excelService = (ExcelServiceImpl) beanFactory
					.getBean(StringUtils.uncapitalize(ExcelServiceImpl.class
							.getSimpleName()));
			factory.addConstructorArgValue(excelService);
		}
		registry.registerBeanDefinition(name, factory.getBeanDefinition());
	}

	/**
	 * 解析format元素
	 * @param e format元素Node节点
	 * @return
	 */
	private Format resolveFormat(Element e) {
		if(e.getNodeName().equals(SchemaName.FORMAT_ELEMENT)) {
			String location = e.getAttribute(SchemaName.FORMAT_LOCATION_ATTR);
			String type = e.getAttribute(SchemaName.FORMAT_TYPE_ATTR);
			String suffix = e.getAttribute(SchemaName.FORMAT_SUFFIX_ATTR);
			String config = e.getAttribute(SchemaName.FORMAT_CONFIG_ATTR);
			String sheet = e.getAttribute(SchemaName.FORMAT_SHEET_ATTR);
			return Format.valueOf(location, type, suffix, config , sheet);
		}
		return null;
	}
}
