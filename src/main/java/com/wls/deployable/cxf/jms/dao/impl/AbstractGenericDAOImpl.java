package com.wls.deployable.cxf.jms.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wls.deployable.cxf.jms.dao.GenericDAO;

public abstract class AbstractGenericDAOImpl<T> implements GenericDAO<T> {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractGenericDAOImpl.class);
	@PersistenceContext(name="oraclePU")
	@Qualifier("oracleEntityManagerFactory")
	private EntityManager em;
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	

	@Transactional(isolation=Isolation.READ_COMMITTED, readOnly=false, rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public T get(Class<T> clazz, Serializable id) {
		return em.find(clazz, id);
	}
	@Transactional(isolation=Isolation.READ_COMMITTED, readOnly=false, rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void update(T domain) {
		em.merge(domain);	
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, readOnly=false, rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void remove(T domain) {
		em.remove(domain);	
	}


	@Transactional(isolation=Isolation.READ_COMMITTED, readOnly=false, rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void save(T domain) {
		if(em != null) {
			LOG.info("========> PERSISTING MOBILE <========");
		}
		em.persist(domain);
		
		
	}

}
