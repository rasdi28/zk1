package com.sdd.zk1.domain;


import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Mproduct {
	
	private Integer mproduct;
	private String productname;
	private BigInteger productprice;
	private int productstock;
	
	@Id
	public Integer getMproduct() {
		return mproduct;
	}
	public void setMproduct(Integer mproduct) {
		this.mproduct = mproduct;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public BigInteger getProductprice() {
		return productprice;
	}
	public void setProductprice(BigInteger productprice) {
		this.productprice = productprice;
	}
	public int getProductstock() {
		return productstock;
	}
	public void setProductstock(int productstock) {
		this.productstock = productstock;
	}
	
}
