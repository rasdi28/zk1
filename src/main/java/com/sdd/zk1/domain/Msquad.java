package com.sdd.zk1.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.google.common.base.Function;

@Entity
public class Msquad {

	private Integer msquadpk;
	private String nik;
	private String squadname;
	private String squademail;
	private String gender;
	private Date joindate;
	private Date resigndate;
	private String isactive;
	private String role;
	private byte[] squadimg;
	private Date lastupdated;
	private String updatedby;
	private Munit munit;
	
	
	

	@Id
	@SequenceGenerator(name="msquad_seq", sequenceName="msquad_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "msquad_seq")
	public Integer getMsquadpk() {
		return msquadpk;
	}
	public void setMsquadpk(Integer msquadpk) {
		this.msquadpk = msquadpk;
	}
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public String getSquadname() {
		return squadname;
	}
	public void setSquadname(String squadname) {
		this.squadname = squadname;
	}
	public String getSquademail() {
		return squademail;
	}
	public void setSquademail(String squademail) {
		this.squademail = squademail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public Date getResigndate() {
		return resigndate;
	}
	public void setResigndate(Date resigndate) {
		this.resigndate = resigndate;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public byte[] getSquadimg() {
		return squadimg;
	}
	public void setSquadimg(byte[] squadimg) {
		this.squadimg = squadimg;
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
	public Munit getMunit() {
		return munit;
	}
	public void setMunit(Munit munit) {
		this.munit = munit;
	}
	
	
	
	
	
	
	
}
