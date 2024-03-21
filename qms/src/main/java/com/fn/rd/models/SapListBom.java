package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sap_list_bom database table.
 * 
 */
@Entity
@Table(name="sap_list_bom")
@NamedQuery(name="SapListBom.findAll", query="SELECT s FROM SapListBom s")
public class SapListBom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String alterItem;

	private String controlLevel;

	private String issueMenthod;

	private String itemCode;

	private String itemName;

	private String location;

	private String otherItemName;

	private String partNumber;

	private int quantity;

	private String SAP_BOM_VERSION_id;

	@Column(name="sap_list_bomcol")
	private String sapListBomcol;

	private String SAP_OITM_ItemCode;

	private String technicalName;

	private String vendor;

	public SapListBom() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlterItem() {
		return this.alterItem;
	}

	public void setAlterItem(String alterItem) {
		this.alterItem = alterItem;
	}

	public String getControlLevel() {
		return this.controlLevel;
	}

	public void setControlLevel(String controlLevel) {
		this.controlLevel = controlLevel;
	}

	public String getIssueMenthod() {
		return this.issueMenthod;
	}

	public void setIssueMenthod(String issueMenthod) {
		this.issueMenthod = issueMenthod;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOtherItemName() {
		return this.otherItemName;
	}

	public void setOtherItemName(String otherItemName) {
		this.otherItemName = otherItemName;
	}

	public String getPartNumber() {
		return this.partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSAP_BOM_VERSION_id() {
		return this.SAP_BOM_VERSION_id;
	}

	public void setSAP_BOM_VERSION_id(String SAP_BOM_VERSION_id) {
		this.SAP_BOM_VERSION_id = SAP_BOM_VERSION_id;
	}

	public String getSapListBomcol() {
		return this.sapListBomcol;
	}

	public void setSapListBomcol(String sapListBomcol) {
		this.sapListBomcol = sapListBomcol;
	}

	public String getSAP_OITM_ItemCode() {
		return this.SAP_OITM_ItemCode;
	}

	public void setSAP_OITM_ItemCode(String SAP_OITM_ItemCode) {
		this.SAP_OITM_ItemCode = SAP_OITM_ItemCode;
	}

	public String getTechnicalName() {
		return this.technicalName;
	}

	public void setTechnicalName(String technicalName) {
		this.technicalName = technicalName;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

}