package com.wls.deployable.cxf.jms.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.wls.deployable.cxf.jms.dao.MobileDAO;
import com.wls.deployable.cxf.jms.entities.Mobile;



public class MobileDAOImpl extends AbstractGenericDAOImpl<Mobile> implements MobileDAO {

	@PersistenceContext(name="oraclePU")
	@Qualifier("oracleEntityManagerFactory")
	private EntityManager em;
	
	@Transactional
	public List<Mobile> findAll() {
		
		List<Mobile> resultList = em.createQuery( "SELECT m FROM Mobile m").getResultList();
		return resultList;
	}

}
