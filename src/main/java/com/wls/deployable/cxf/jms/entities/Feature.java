package com.wls.deployable.cxf.jms.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feature {	
	
	@Id
	private int id;
	private String featureName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

}
