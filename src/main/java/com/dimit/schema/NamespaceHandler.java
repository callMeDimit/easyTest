package com.dimit.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Dimit 2015年1月17日
 * Test标签处理类
 */
public class NamespaceHandler extends NamespaceHandlerSupport {
	
	@Override
	public void init() {
		registerBeanDefinitionParser(SchemaName.CONFIG_ELEMENT,new ConfigDefinitionParse());
	}

}
