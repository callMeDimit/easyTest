package com.dimit.launch;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dimit.Test;
import com.dimit.classLoad.ClassLoaderServiceImpl;

/**
 * Dimit 2015年1月17日
 */
public class MainClass {
	public static final String CONFIG_LOCATION_DELIMITERS = ",; \t\n:";
	public static final String CONFIG="Beans.xml";
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(CONFIG);
		Test t = (Test) factory.getBean("test");
		t.print();
	}
}

