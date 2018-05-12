package com.wls.deployable.cxf.jms.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wls.deployable.cxf.jms.dao.FeatureDAO;
import com.wls.deployable.cxf.jms.entities.Feature;


public class FeatureDAOImpl extends AbstractGenericDAOImpl<Feature> implements FeatureDAO {

	
	
	@PersistenceContext(name="oraclePU")
	@Qualifier("oracleEntityManagerFactory")
	private EntityManager em;
	
	@Transactional
	public List<Feature> findAll() {
		List<Feature> resultList = em.createQuery( "SELECT m FROM Feature m").getResultList();
		return resultList;
	}

}
