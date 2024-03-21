package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the planning_production_order database table.
 * 
 */
@Entity
@Table(name="planning_production_order")
@NamedQuery(name="PlanningProductionOrder.findAll", query="SELECT p FROM PlanningProductionOrder p")
public class PlanningProductionOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PO_ID")
	private int poId;

	@Column(name="bom_version")
	private String bomVersion;

	@Temporal(TemporalType.DATE)
	@Column(name="complete_date")
	private Date completeDate;

	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;

	@Temporal(TemporalType.DATE)
	@Column(name="expected_complete_date")
	private Date expectedCompleteDate;

	@Temporal(TemporalType.DATE)
	@Column(name="last_modified_date")
	private Date lastModifiedDate;

	private String note;

	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private Date orderDate;

	@Column(name="order_item")
	private String orderItem;

	@Column(name="order_item_product_code")
	private int orderItemProductCode;

	private String priority;

	private int quantity;

	@Temporal(TemporalType.DATE)
	@Column(name="requested_start_date")
	private Date requestedStartDate;

	private String state;

	public PlanningProductionOrder() {
	}

	public int getPoId() {
		return this.poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public String getBomVersion() {
		return this.bomVersion;
	}

	public void setBomVersion(String bomVersion) {
		this.bomVersion = bomVersion;
	}

	public Date getCompleteDate() {
		return this.completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpectedCompleteDate() {
		return this.expectedCompleteDate;
	}

	public void setExpectedCompleteDate(Date expectedCompleteDate) {
		this.expectedCompleteDate = expectedCompleteDate;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderItem() {
		return this.orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	public int getOrderItemProductCode() {
		return this.orderItemProductCode;
	}

	public void setOrderItemProductCode(int orderItemProductCode) {
		this.orderItemProductCode = orderItemProductCode;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getRequestedStartDate() {
		return this.requestedStartDate;
	}

	public void setRequestedStartDate(Date requestedStartDate) {
		this.requestedStartDate = requestedStartDate;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}