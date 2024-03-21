package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the cmc_oitm database table.
 * 
 */
@Entity
@Table(name="cmc_oitm")
@NamedQuery(name="CmcOitm.findAll", query="SELECT c FROM CmcOitm c")
public class CmcOitm implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigInteger baseEntry;

	private BigInteger baseLine;

	private BigInteger baseType;

	@Temporal(TemporalType.DATE)
	private Date createdate;

	private String createtime;

	private String docStatus;

	@Id
	private String itemcode;

	private String itemName;

	private float plannedQty;

	private float quantity;

	private float rjctQty;

	private String u_IGroup;

	private String u_ProductBranch;

	private String u_RDCode;

	private String usersign;

	private String usersign2;

	private String warehouse;

	public CmcOitm() {
	}

	public BigInteger getBaseEntry() {
		return this.baseEntry;
	}

	public void setBaseEntry(BigInteger baseEntry) {
		this.baseEntry = baseEntry;
	}

	public BigInteger getBaseLine() {
		return this.baseLine;
	}

	public void setBaseLine(BigInteger baseLine) {
		this.baseLine = baseLine;
	}

	public BigInteger getBaseType() {
		return this.baseType;
	}

	public void setBaseType(BigInteger baseType) {
		this.baseType = baseType;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getDocStatus() {
		return this.docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPlannedQty() {
		return this.plannedQty;
	}

	public void setPlannedQty(float plannedQty) {
		this.plannedQty = plannedQty;
	}

	public float getQuantity() {
		return this.quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getRjctQty() {
		return this.rjctQty;
	}

	public void setRjctQty(float rjctQty) {
		this.rjctQty = rjctQty;
	}

	public String getU_IGroup() {
		return this.u_IGroup;
	}

	public void setU_IGroup(String u_IGroup) {
		this.u_IGroup = u_IGroup;
	}

	public String getU_ProductBranch() {
		return this.u_ProductBranch;
	}

	public void setU_ProductBranch(String u_ProductBranch) {
		this.u_ProductBranch = u_ProductBranch;
	}

	public String getU_RDCode() {
		return this.u_RDCode;
	}

	public void setU_RDCode(String u_RDCode) {
		this.u_RDCode = u_RDCode;
	}

	public String getUsersign() {
		return this.usersign;
	}

	public void setUsersign(String usersign) {
		this.usersign = usersign;
	}

	public String getUsersign2() {
		return this.usersign2;
	}

	public void setUsersign2(String usersign2) {
		this.usersign2 = usersign2;
	}

	public String getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

}