package com.wls.deployable.cxf.listener;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.wls.deployable.cxf.stockquote.StockQuotePortTypeImpl;

public class DemoMain {

	@Transactional
	public static void main(String[] args) {
		
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/config/applicationContext.xml");
		
		//ctx.getBean(MyListener.class).onApplicationEvent(null);
		StockQuotePortTypeImpl stock = (StockQuotePortTypeImpl)ctx.getBean("stock");
		stock.getLastTradePrice(null);
	}
}
