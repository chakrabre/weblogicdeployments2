package com.wls.deployable.cxf.listener;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain {

	
	public static void main(String[] args) {
		
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ctx.getBean(MyListener.class).onApplicationEvent(null);
		
	}
}
