package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sap_batch database table.
 * 
 */
@Entity
@Table(name="sap_batch")
@NamedQuery(name="SapBatch.findAll", query="SELECT s FROM SapBatch s")
public class SapBatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date u_Date;

	private String u_DChuyen;

	private int u_Production;

	public SapBatch() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getU_Date() {
		return this.u_Date;
	}

	public void setU_Date(Date u_Date) {
		this.u_Date = u_Date;
	}

	public String getU_DChuyen() {
		return this.u_DChuyen;
	}

	public void setU_DChuyen(String u_DChuyen) {
		this.u_DChuyen = u_DChuyen;
	}

	public int getU_Production() {
		return this.u_Production;
	}

	public void setU_Production(int u_Production) {
		this.u_Production = u_Production;
	}

}