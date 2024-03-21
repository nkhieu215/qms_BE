package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sap_bom_version database table.
 * 
 */
@Entity
@Table(name="sap_bom_version")
@NamedQuery(name="SapBomVersion.findAll", query="SELECT s FROM SapBomVersion s")
public class SapBomVersion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private int active;

	@Temporal(TemporalType.DATE)
	private Date dueDate;

	private String producitonNo;

	private String productName;

	private String remark;

	private String speciality;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	private String u_DocURL;

	private String u_Proname;

	private String u_ProNo;

	private String versions;

	private String warehouse;

	public SapBomVersion() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getProducitonNo() {
		return this.producitonNo;
	}

	public void setProducitonNo(String producitonNo) {
		this.producitonNo = producitonNo;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getU_DocURL() {
		return this.u_DocURL;
	}

	public void setU_DocURL(String u_DocURL) {
		this.u_DocURL = u_DocURL;
	}

	public String getU_Proname() {
		return this.u_Proname;
	}

	public void setU_Proname(String u_Proname) {
		this.u_Proname = u_Proname;
	}

	public String getU_ProNo() {
		return this.u_ProNo;
	}

	public void setU_ProNo(String u_ProNo) {
		this.u_ProNo = u_ProNo;
	}

	public String getVersions() {
		return this.versions;
	}

	public void setVersions(String versions) {
		this.versions = versions;
	}

	public String getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

}