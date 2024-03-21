package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the pqc_bom_workorder database table.
 * 
 */
@Entity
@Table(name="pqc_bom_workorder")
@NamedQuery(name="PqcBomWorkorder.findAll", query="SELECT p FROM PqcBomWorkorder p")
public class PqcBomWorkorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="bom_quantity")
	private String bomQuantity;

	@Column(name="item_code")
	private String itemCode;

	@Column(name="item_name")
	private String itemName;

	@Column(name="part_number")
	private String partNumber;

	private String quantity;

	private String vendor;

	@Column(name = "versions")
	private String version;

	@Column(name="work_order_id")
	private Long workOrderId;

	@Column(name="work_order_quantity")
	private String workOrderQuantity;
	
	@Column(name="uitm_tech")
	private String uitmTech;
	
	@Column(name="ualter")
	private String ualter;
	
	@Column(name="uremarks")
	private String uremarks;
	
	@Column(name="uctr_level")
	private String uctrLevel;
	
	@Column(name="uother_nam")
	private String uotherNam;
	
	@Column(name="ulocation")
	private String ulocation;

	@ManyToOne(optional=true)
	@JoinColumn(name = "work_order_id", insertable=false, updatable=false)
	@JsonIgnore
	private PqcWorkOrder pqcWorkOrder;

	
	public String getUlocation() {
		return ulocation;
	}

	public void setUlocation(String ulocation) {
		this.ulocation = ulocation;
	}

	public String getUitmTech() {
		return uitmTech;
	}

	public void setUitmTech(String uitmTech) {
		this.uitmTech = uitmTech;
	}

	public String getUalter() {
		return ualter;
	}

	public void setUalter(String ualter) {
		this.ualter = ualter;
	}

	public String getUremarks() {
		return uremarks;
	}

	public void setUremarks(String uremarks) {
		this.uremarks = uremarks;
	}

	public String getUctrLevel() {
		return uctrLevel;
	}

	public void setUctrLevel(String uctrLevel) {
		this.uctrLevel = uctrLevel;
	}

	public String getUotherNam() {
		return uotherNam;
	}

	public void setUotherNam(String uotherNam) {
		this.uotherNam = uotherNam;
	}

	public PqcBomWorkorder() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBomQuantity() {
		return this.bomQuantity;
	}

	public void setBomQuantity(String bomQuantity) {
		this.bomQuantity = bomQuantity;
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

	public String getPartNumber() {
		return this.partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Long getWorkOrderId() {
		return this.workOrderId;
	}

	public void setWorkOrderId(Long workOrderId) {
		this.workOrderId = workOrderId;
	}

	public String getWorkOrderQuantity() {
		return this.workOrderQuantity;
	}

	public void setWorkOrderQuantity(String workOrderQuantity) {
		this.workOrderQuantity = workOrderQuantity;
	}

}