package com.wls.deployable.cxf.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class MyListener implements ApplicationListener<ContextRefreshedEvent> {
  
	@Autowired
	DataSource ds;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyListener.class);
    @SuppressWarnings("unchecked")
	public void onApplicationEvent(ContextRefreshedEvent event) {
        JdbcTemplate template = new JdbcTemplate(ds);
        
        InputStream sqlFileStream = this.getClass().getResourceAsStream("/sql/populateMobiles.sql");
        try {
			List<String> lines = IOUtils.readLines(sqlFileStream);
			String sqlStmtArray[] = new String[lines.size()];
			int i=0;
			LOGGER.info("Executing SQL Statements :");
			for(String sql : lines) {
				LOGGER.info(sql);
				sqlStmtArray[i]= sql;
				i++;
			}
					
			template.batchUpdate(sqlStmtArray);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}