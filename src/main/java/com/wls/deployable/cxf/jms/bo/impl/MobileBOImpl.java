package com.wls.deployable.cxf.jms.bo.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wls.deployable.cxf.jms.bo.MobileBO;
import com.wls.deployable.cxf.jms.dao.MobileDAO;
import com.wls.deployable.cxf.jms.entities.Mobile;



public class MobileBOImpl implements MobileBO {


	@Autowired
	private MobileDAO mobileDAO;

	public MobileDAO getMobileDAO() {
		return mobileDAO;
	}

	public void setMobileDAO(MobileDAO mobileDAO) {
		System.out.println("mob DAo Set **********************************************************");
		this.mobileDAO = mobileDAO;
	}


	public void save(Mobile domain) {
		mobileDAO.save(domain);
	}


	public void update(Mobile domain) {
		mobileDAO.update(domain);
	}


	public void delete(Mobile domain) {
		mobileDAO.remove(domain);
	}


	public Mobile get(Class<Mobile> clazz, Serializable id) {
		return mobileDAO.get(clazz, id);
	}

	public List<Mobile> findAll() {
		return mobileDAO.findAll();
	}	
}
