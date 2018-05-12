package com.wls.deployable.cxf.jms.bo;

import java.io.Serializable;
import java.util.List;

import com.wls.deployable.cxf.jms.entities.Mobile;


public interface MobileBO {
	
	void save(Mobile domain);

	void update(Mobile domain);

	void delete(Mobile domain);

	public Mobile get(Class<Mobile> clazz, Serializable id);
	
	public List<Mobile> findAll();

}
