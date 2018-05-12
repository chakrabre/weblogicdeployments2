package com.wls.deployable.cxf.stockquote;

import javax.jws.WebService;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cxf.deployable.wls.stockquote.StockQuotePortType;
import com.cxf.deployable.wls.stockquote.TradePrice;
import com.cxf.deployable.wls.stockquote.TradePriceRequest;
import com.wls.deployable.cxf.jms.StockMessageSender;
import com.wls.deployable.cxf.jms.bo.impl.MobileBOImpl;
import com.wls.deployable.cxf.jms.entities.Mobile;

@WebService(endpointInterface="com.cxf.deployable.wls.stockquote.StockQuotePortType")
public class StockQuotePortTypeImpl implements StockQuotePortType {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	MobileBOImpl mobileBO;
	
	@Autowired
	DataSource ds;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StockQuotePortTypeImpl.class);
	
	@Override
	@Transactional
	public TradePrice getLastTradePrice(TradePriceRequest body) {
	
		  JdbcTemplate temp = new JdbcTemplate(ds);
		  temp.update("UPDATE MOBILE SET MODELNAME ='iPhone' WHERE ID = 3");
		  LOGGER.info("Done JDBCTEMPLATE update ...");
		

		Mobile mobile = new Mobile();
		
		mobile.setId(9);
		mobile.setBrand("Samsung");
		mobile.setModelName("Galaxy S8");
		mobile.setOs("Android");
		
		LOGGER.info("Update DB with Hibernate BO/DO .. !!!");
		mobileBO.save(mobile);
		LOGGER.info("Database updated .. !!!");
		StockMessageSender sender = context.getBean(StockMessageSender.class);
		sender.sendMessage("Hello wls-deployable-cxf app .  !!!", "/com/jms/dev/distqueue");
		
		TradePrice tradePrice = new TradePrice();
		tradePrice.setPrice(100f);
		
		return tradePrice;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

}
