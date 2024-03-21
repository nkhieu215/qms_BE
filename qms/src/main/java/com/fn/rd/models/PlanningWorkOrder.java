package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the planning_work_order database table.
 * 
 */
@Entity
@Table(name="planning_work_order")
@NamedQuery(name="PlanningWorkOrder.findAll", query="SELECT p FROM PlanningWorkOrder p")
public class PlanningWorkOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="planning_work_order_id")
	private int planningWorkOrderId;

	@Column(name="bom_version")
	private String bomVersion;

	@Column(name="branch_code")
	private String branchCode;

	@Temporal(TemporalType.DATE)
	@Column(name="END_TIME")
	private Date endTime;

	@Column(name="group_code")
	private String groupCode;

	@Column(name="group_name")
	private String groupName;

	@Column(name="LINE_ID")
	private int lineId;

	@Column(name="PRODUCT_ID")
	private int productId;

	@Column(name="PRODUCT_ORDER_ID")
	private int productOrderId;

	@Column(name="QUANTITY_PLAN")
	private int quantityPlan;

	private String sap_cmc_oitm_Itemcode;

	private String sap_WO_ID;

	@Temporal(TemporalType.DATE)
	@Column(name="START_TIME")
	private Date startTime;

	private String state;

	private int status;

	public PlanningWorkOrder() {
	}

	public int getPlanningWorkOrderId() {
		return this.planningWorkOrderId;
	}

	public void setPlanningWorkOrderId(int planningWorkOrderId) {
		this.planningWorkOrderId = planningWorkOrderId;
	}

	public String getBomVersion() {
		return this.bomVersion;
	}

	public void setBomVersion(String bomVersion) {
		this.bomVersion = bomVersion;
	}

	public String getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getGroupCode() {
		return this.groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getLineId() {
		return this.lineId;
	}

	public void setLineId(int lineId) {
		this.lineId = lineId;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductOrderId() {
		return this.productOrderId;
	}

	public void setProductOrderId(int productOrderId) {
		this.productOrderId = productOrderId;
	}

	public int getQuantityPlan() {
		return this.quantityPlan;
	}

	public void setQuantityPlan(int quantityPlan) {
		this.quantityPlan = quantityPlan;
	}

	public String getSap_cmc_oitm_Itemcode() {
		return this.sap_cmc_oitm_Itemcode;
	}

	public void setSap_cmc_oitm_Itemcode(String sap_cmc_oitm_Itemcode) {
		this.sap_cmc_oitm_Itemcode = sap_cmc_oitm_Itemcode;
	}

	public String getSap_WO_ID() {
		return this.sap_WO_ID;
	}

	public void setSap_WO_ID(String sap_WO_ID) {
		this.sap_WO_ID = sap_WO_ID;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}