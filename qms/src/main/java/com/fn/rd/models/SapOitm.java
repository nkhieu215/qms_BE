package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the sap_oitm database table.
 * 
 */
@Entity
@Table(name="sap_oitm")
@NamedQuery(name="SapOitm.findAll", query="SELECT s FROM SapOitm s")
public class SapOitm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String itemCode;

	private String frgnName;

	private String itemName;

	private short itmsGrpCod;

	private String u_DGroup;

	private String u_DGroupName;

	private String u_Forcast;

	private String u_IGroup;

	private String u_IGroupName;

	@Lob
	@Column(name="U_MSL")
	private String uMsl;

	private BigDecimal u_Package;

	private String u_PartNumber;

	private String u_ProductBranch;

	private String u_ProductGroup;

	@Column(name="U_RDCODE")
	private String uRdcode;

	private String u_ShortName;

	@Column(name="U_SUBGR")
	private String uSubgr;

	private String u_SUBGRName;

	@Lob
	private String u_TechName;

	public SapOitm() {
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getFrgnName() {
		return this.frgnName;
	}

	public void setFrgnName(String frgnName) {
		this.frgnName = frgnName;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public short getItmsGrpCod() {
		return this.itmsGrpCod;
	}

	public void setItmsGrpCod(short itmsGrpCod) {
		this.itmsGrpCod = itmsGrpCod;
	}

	public String getU_DGroup() {
		return this.u_DGroup;
	}

	public void setU_DGroup(String u_DGroup) {
		this.u_DGroup = u_DGroup;
	}

	public String getU_DGroupName() {
		return this.u_DGroupName;
	}

	public void setU_DGroupName(String u_DGroupName) {
		this.u_DGroupName = u_DGroupName;
	}

	public String getU_Forcast() {
		return this.u_Forcast;
	}

	public void setU_Forcast(String u_Forcast) {
		this.u_Forcast = u_Forcast;
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

	public String getUMsl() {
		return this.uMsl;
	}

	public void setUMsl(String uMsl) {
		this.uMsl = uMsl;
	}

	public BigDecimal getU_Package() {
		return this.u_Package;
	}

	public void setU_Package(BigDecimal u_Package) {
		this.u_Package = u_Package;
	}

	public String getU_PartNumber() {
		return this.u_PartNumber;
	}

	public void setU_PartNumber(String u_PartNumber) {
		this.u_PartNumber = u_PartNumber;
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

	public String getURdcode() {
		return this.uRdcode;
	}

	public void setURdcode(String uRdcode) {
		this.uRdcode = uRdcode;
	}

	public String getU_ShortName() {
		return this.u_ShortName;
	}

	public void setU_ShortName(String u_ShortName) {
		this.u_ShortName = u_ShortName;
	}

	public String getUSubgr() {
		return this.uSubgr;
	}

	public void setUSubgr(String uSubgr) {
		this.uSubgr = uSubgr;
	}

	public String getU_SUBGRName() {
		return this.u_SUBGRName;
	}

	public void setU_SUBGRName(String u_SUBGRName) {
		this.u_SUBGRName = u_SUBGRName;
	}

	public String getU_TechName() {
		return this.u_TechName;
	}

	public void setU_TechName(String u_TechName) {
		this.u_TechName = u_TechName;
	}

}