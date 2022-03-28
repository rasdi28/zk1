package com.sdd.zk1.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "Mdepartement.findAll", query = "SELECT m FROM Mdepartement m")
public class Mdepartement implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mdepartementpk;
	private String deptname;
	private String deptcode;

	@Id
	@SequenceGenerator(name = "MDEPARTEMENT_MDEPARTEMENTPK_GENERATOR", sequenceName = "MDEPARTEMENT_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MDEPARTEMENT_MDEPARTEMENTPK_GENERATOR")
	@Column(unique = true, nullable = false)
	public Integer getMdepartementpk() {
		return mdepartementpk;
	}

	public void setMdepartementpk(Integer mdepartementpk) {
		this.mdepartementpk = mdepartementpk;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

}
