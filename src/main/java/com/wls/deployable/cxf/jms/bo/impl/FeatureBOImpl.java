package com.wls.deployable.cxf.jms.bo.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wls.deployable.cxf.jms.bo.FeatureBO;
import com.wls.deployable.cxf.jms.dao.FeatureDAO;
import com.wls.deployable.cxf.jms.entities.Feature;



public class FeatureBOImpl implements FeatureBO {


	@Autowired
	private FeatureDAO featureDAO;

	public FeatureDAO getFeatureDAO() {
		return featureDAO;
	}

	public void setFeatureDAO(FeatureDAO featureDAO) {
		this.featureDAO = featureDAO;
	}

	public void save(Feature domain) {
		featureDAO.save(domain);
	}


	public void update(Feature domain) {
		featureDAO.update(domain);
	}

	public void delete(Feature domain) {
		featureDAO.remove(domain);
	}

	public Feature get(Class<Feature> clazz, Serializable id) {
		return featureDAO.get(clazz, id);
	}

	public List<Feature> findAll() {
		return featureDAO.findAll();
	}	
	
}
