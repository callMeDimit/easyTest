package com.dimit.launch;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Dimit 2015年1月17日
 */
public class MainClass {
	public static final String CONFIG_LOCATION_DELIMITERS = ",; \t\n:";
	public static final String CONFIG="Beans.xml";
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(CONFIG);
	}
}

