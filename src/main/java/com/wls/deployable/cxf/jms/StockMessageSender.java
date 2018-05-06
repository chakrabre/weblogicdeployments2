package com.wls.deployable.cxf.jms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class StockMessageSender {
	
	private static final Logger LOG = LoggerFactory.getLogger(StockMessageSender.class);
	
	@Autowired
	private JmsTemplate template;
	

	public JmsTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}
	
	
	
	public void sendMessage(String message, String destination) {
		template.convertAndSend(destination, message);
		LOG.info("==========Message has been sent==========\n");
	}

}
