package com.wls.deployable.cxf.stockquote;

import java.util.List;

import javax.jws.WebService;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cxf.deployable.wls.stockquote.StockQuotePortType;
import com.cxf.deployable.wls.stockquote.TradePrice;
import com.cxf.deployable.wls.stockquote.TradePriceRequest;
import com.distributed.tx.demo.distTxDemo.entities.Mobile;
import com.wls.deployable.cxf.jms.StockMessageSender;
import com.wls.deployable.cxf.listener.MyListener;

@Component
@WebService(endpointInterface="com.cxf.deployable.wls.stockquote.StockQuotePortType")
public class StockQuotePortTypeImpl implements StockQuotePortType {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	DataSource ds;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StockQuotePortTypeImpl.class);
	
	@Override
	public TradePrice getLastTradePrice(TradePriceRequest body) {
	
		JdbcTemplate temp = new JdbcTemplate(ds);
		
		temp.update("UPDATE MOBILE SET MODELNAME ='iPhone' WHERE ID = 3");
		LOGGER.info("Done JDBCTEMPLATE update ...");
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
