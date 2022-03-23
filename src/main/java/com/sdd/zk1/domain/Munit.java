package com.sdd.zk1.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class Munit {

	private Integer munitpk;
	private String unitcode;
	private String unitname;
	private String isunitproject;
	private Date lastupdated;
	private String updatedby;
	
	@Id
	@SequenceGenerator(name="unit_seq", sequenceName="munit_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="munit_seq")
	
	
	
	public Integer getMunitpk() {
		return munitpk;
	}
	
	
	
	public void setMunitpk(Integer munitpk) {
		this.munitpk = munitpk;
	}
	public String getUnitcode() {
		return unitcode;
	}
	public void setUnitcode(String unitcode) {
		this.unitcode = unitcode;
	}
	public String getUnitname() {
		return unitname;
	}
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	public String getIsunitproject() {
		return isunitproject;
	}
	public void setIsunitproject(String isunitproject) {
		this.isunitproject = isunitproject;
	}
	public Date getLastupdated() {
		return lastupdated;
	}
	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	
	
	
	
}
