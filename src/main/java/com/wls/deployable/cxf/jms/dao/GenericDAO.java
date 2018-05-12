package com.wls.deployable.cxf.jms.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T> {
	
	public T get(Class<T> clazz, Serializable id);
	
	public void update( T domain);
	
	public void remove( T domain);
	
	public void save( T domain);
	
	public List<T> findAll();
	
}
