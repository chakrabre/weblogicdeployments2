package com.wls.deployable.cxf.jms.bo;

import java.io.Serializable;
import java.util.List;

import com.wls.deployable.cxf.jms.entities.Feature;



public interface FeatureBO {
	
	void save(Feature domain);

	void update(Feature domain);

	void delete(Feature domain);

	public Feature get(Class<Feature> clazz, Serializable id);
	
	public List<Feature> findAll();

}
