package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_catalog database table.
 * 
 */
@Entity
@Table(name="product_catalog")
@NamedQuery(name="ProductCatalog.findAll", query="SELECT p FROM ProductCatalog p")
public class ProductCatalog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_catalog_code")
	private String productCatalogCode;

	@Column(name="product_catalog_name")
	private String productCatalogName;

	private int status;

	public ProductCatalog() {
	}

	public String getProductCatalogCode() {
		return this.productCatalogCode;
	}

	public void setProductCatalogCode(String productCatalogCode) {
		this.productCatalogCode = productCatalogCode;
	}

	public String getProductCatalogName() {
		return this.productCatalogName;
	}

	public void setProductCatalogName(String productCatalogName) {
		this.productCatalogName = productCatalogName;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}