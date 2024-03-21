package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the error_type database table.
 * 
 */
@Entity
@Table(name="error_type")
@NamedQuery(name="ErrorType.findAll", query="SELECT e FROM ErrorType e")
public class ErrorType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="error_type_id")
	private int errorTypeId;

	@Column(name="error_error_id")
	private int errorErrorId;

	@Column(name="error_type_code")
	private String errorTypeCode;

	@Column(name="error_type_name")
	private String errorTypeName;

	private int status;

	public ErrorType() {
	}

	public int getErrorTypeId() {
		return this.errorTypeId;
	}

	public void setErrorTypeId(int errorTypeId) {
		this.errorTypeId = errorTypeId;
	}

	public int getErrorErrorId() {
		return this.errorErrorId;
	}

	public void setErrorErrorId(int errorErrorId) {
		this.errorErrorId = errorErrorId;
	}

	public String getErrorTypeCode() {
		return this.errorTypeCode;
	}

	public void setErrorTypeCode(String errorTypeCode) {
		this.errorTypeCode = errorTypeCode;
	}

	public String getErrorTypeName() {
		return this.errorTypeName;
	}

	public void setErrorTypeName(String errorTypeName) {
		this.errorTypeName = errorTypeName;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}