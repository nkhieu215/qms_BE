package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stage_error_mapping database table.
 * 
 */
@Entity
@Table(name="stage_error_mapping")
@NamedQuery(name="StageErrorMapping.findAll", query="SELECT s FROM StageErrorMapping s")
public class StageErrorMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="error_code")
	private String errorCode;

	@Column(name="error_list_error_id")
	private int errorListErrorId;

	@Column(name="product_stage_code")
	private String productStageCode;

	private int status;

	public StageErrorMapping() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorListErrorId() {
		return this.errorListErrorId;
	}

	public void setErrorListErrorId(int errorListErrorId) {
		this.errorListErrorId = errorListErrorId;
	}

	public String getProductStageCode() {
		return this.productStageCode;
	}

	public void setProductStageCode(String productStageCode) {
		this.productStageCode = productStageCode;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}