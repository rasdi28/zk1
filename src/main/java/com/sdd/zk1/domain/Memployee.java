package com.sdd.zk1.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQuery(name = "Memployee.findAll", query = "SELECT m FROM Memployee m")
public class Memployee {
	private Integer memployeepk;
	private String employeename;
	private String npp;
	private Date dob;
	private String address;
	private Mdepartement mdepartement;
	//tambahan
	
	

	
	

	@Id
	@SequenceGenerator(name = "MEMPLOYEE_MEMPLOYEEPK_GENERATOR", sequenceName = "MEMPLOYEE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMPLOYEE_MEMPLOYEEPK_GENERATOR")
	@Column(unique = true, nullable = false)
	public Integer getMemployeepk() {
		return memployeepk;
	}

	public void setMemployeepk(Integer memployeepk) {
		this.memployeepk = memployeepk;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getNpp() {
		return npp;
	}

	public void setNpp(String npp) {
		this.npp = npp;
	}

	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	//tambahan
	@ManyToOne
	@JoinColumn(name="mdepartementfk")
	public Mdepartement getMdepartement() {
		return mdepartement;
	}

	public void setMdepartement(Mdepartement mdepartement) {
		this.mdepartement = mdepartement;
	}

}
