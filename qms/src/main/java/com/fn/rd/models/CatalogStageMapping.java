package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the catalog_stage_mapping database table.
 * 
 */
@Entity
@Table(name="catalog_stage_mapping")
@NamedQuery(name="CatalogStageMapping.findAll", query="SELECT c FROM CatalogStageMapping c")
public class CatalogStageMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="product_catalog_code")
	private String productCatalogCode;

	@Column(name="product_catalog_product_catalog_code")
	private String productCatalogProductCatalogCode;

	@Column(name="product_stage_code")
	private String productStageCode;

	@Column(name="stage_code_stage_code")
	private String stageCodeStageCode;

	@Column(name="stage_error_mapping_id")
	private int stageErrorMappingId;

	private int status;

	public CatalogStageMapping() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductCatalogCode() {
		return this.productCatalogCode;
	}

	public void setProductCatalogCode(String productCatalogCode) {
		this.productCatalogCode = productCatalogCode;
	}

	public String getProductCatalogProductCatalogCode() {
		return this.productCatalogProductCatalogCode;
	}

	public void setProductCatalogProductCatalogCode(String productCatalogProductCatalogCode) {
		this.productCatalogProductCatalogCode = productCatalogProductCatalogCode;
	}

	public String getProductStageCode() {
		return this.productStageCode;
	}

	public void setProductStageCode(String productStageCode) {
		this.productStageCode = productStageCode;
	}

	public String getStageCodeStageCode() {
		return this.stageCodeStageCode;
	}

	public void setStageCodeStageCode(String stageCodeStageCode) {
		this.stageCodeStageCode = stageCodeStageCode;
	}

	public int getStageErrorMappingId() {
		return this.stageErrorMappingId;
	}

	public void setStageErrorMappingId(int stageErrorMappingId) {
		this.stageErrorMappingId = stageErrorMappingId;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}