package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "prodtab")
public class Product {

	@Id
	@Column(name = "pid")
	@GeneratedValue(generator = "mygen")
	@GenericGenerator(name = "mygen", strategy = "increment")
	private Integer prodID;

	@Column(name = "pname")
	private String productName;

	@Column(name = "pcost")
	private Double productCost;

	@Column(name = "pdesc")
	private String productDesc;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Integer getProdID() {
		return prodID;
	}

	public void setProdID(Integer prodID) {
		this.prodID = prodID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductCost() {
		return productCost;
	}

	public void setProductCost(Double productCost) {
		this.productCost = productCost;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Product(Integer prodID) {
		super();
		this.prodID = prodID;
	}

	@Override
	public String toString() {
		return "Product [prodID=" + prodID + ", productName=" + productName + ", productCost=" + productCost
				+ ", productDesc=" + productDesc + "]";
	}
	

	// ()->manorama web sulation

}
