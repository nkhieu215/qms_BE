package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the sap_workorder database table.
 * 
 */
@Entity
@Table(name="sap_workorder")
@NamedQuery(name="SapWorkorder.findAll", query="SELECT s FROM SapWorkorder s")
public class SapWorkorder implements Serializable {
	
	//lenh san xuat
	
	private static final long serialVersionUID = 1L;

	@Id
	private int docEntry;

	private String cardCode;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private int docNum;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;

	private String itemCode;

	private int originNum;

	private String originType;

	private BigDecimal plannedQty;

	@Temporal(TemporalType.TIMESTAMP)
	private Date postDate;

	private String project;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	private String status;

	private String supplCode;

	private String type;

	private String u_ProductCode;

	@Column(name="U_RDCODE")
	private String uRdcode;

	private String u_Spec;

	private String u_Version;

	private String uom;

	private int uomEntry;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	private short userSign;

	private String warehouse;

	public SapWorkorder() {
	}

	public int getDocEntry() {
		return this.docEntry;
	}

	public void setDocEntry(int docEntry) {
		this.docEntry = docEntry;
	}	

	public String getCardCode() {
		return this.cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getDocNum() {
		return this.docNum;
	}

	public void setDocNum(int docNum) {
		this.docNum = docNum;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getOriginNum() {
		return this.originNum;
	}

	public void setOriginNum(int originNum) {
		this.originNum = originNum;
	}

	public String getOriginType() {
		return this.originType;
	}

	public void setOriginType(String originType) {
		this.originType = originType;
	}

	public BigDecimal getPlannedQty() {
		return this.plannedQty;
	}

	public void setPlannedQty(BigDecimal plannedQty) {
		this.plannedQty = plannedQty;
	}

	public Date getPostDate() {
		return this.postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupplCode() {
		return this.supplCode;
	}

	public void setSupplCode(String supplCode) {
		this.supplCode = supplCode;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getU_ProductCode() {
		return this.u_ProductCode;
	}

	public void setU_ProductCode(String u_ProductCode) {
		this.u_ProductCode = u_ProductCode;
	}

	public String getURdcode() {
		return this.uRdcode;
	}

	public void setURdcode(String uRdcode) {
		this.uRdcode = uRdcode;
	}

	public String getU_Spec() {
		return this.u_Spec;
	}

	public void setU_Spec(String u_Spec) {
		this.u_Spec = u_Spec;
	}

	public String getU_Version() {
		return this.u_Version;
	}

	public void setU_Version(String u_Version) {
		this.u_Version = u_Version;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public int getUomEntry() {
		return this.uomEntry;
	}

	public void setUomEntry(int uomEntry) {
		this.uomEntry = uomEntry;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public short getUserSign() {
		return this.userSign;
	}

	public void setUserSign(short userSign) {
		this.userSign = userSign;
	}

	public String getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

}