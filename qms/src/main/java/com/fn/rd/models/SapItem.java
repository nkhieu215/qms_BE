package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sap_item database table.
 * 
 */
@Entity
@Table(name="sap_item")
@NamedQuery(name="SapItem.findAll", query="SELECT s FROM SapItem s")
public class SapItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String itemcode;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;

	private String createhourse;

	private String doctype;

	private String itemName;

	private String status;

	private String u_IGroup;

	private String u_IGroupName;

	private String u_ProductBranch;

	private String u_ProductGroup;

	private String u_RDCode;

	private String u_SubGRName;

	private String usersign2;

	public SapItem() {
	}

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getCreatehourse() {
		return this.createhourse;
	}

	public void setCreatehourse(String createhourse) {
		this.createhourse = createhourse;
	}

	public String getDoctype() {
		return this.doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getU_IGroup() {
		return this.u_IGroup;
	}

	public void setU_IGroup(String u_IGroup) {
		this.u_IGroup = u_IGroup;
	}

	public String getU_IGroupName() {
		return this.u_IGroupName;
	}

	public void setU_IGroupName(String u_IGroupName) {
		this.u_IGroupName = u_IGroupName;
	}

	public String getU_ProductBranch() {
		return this.u_ProductBranch;
	}

	public void setU_ProductBranch(String u_ProductBranch) {
		this.u_ProductBranch = u_ProductBranch;
	}

	public String getU_ProductGroup() {
		return this.u_ProductGroup;
	}

	public void setU_ProductGroup(String u_ProductGroup) {
		this.u_ProductGroup = u_ProductGroup;
	}

	public String getU_RDCode() {
		return this.u_RDCode;
	}

	public void setU_RDCode(String u_RDCode) {
		this.u_RDCode = u_RDCode;
	}

	public String getU_SubGRName() {
		return this.u_SubGRName;
	}

	public void setU_SubGRName(String u_SubGRName) {
		this.u_SubGRName = u_SubGRName;
	}

	public String getUsersign2() {
		return this.usersign2;
	}

	public void setUsersign2(String usersign2) {
		this.usersign2 = usersign2;
	}

}