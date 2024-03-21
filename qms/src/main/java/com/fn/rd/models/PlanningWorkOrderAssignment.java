package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the planning_work_order_assignment database table.
 * 
 */
@Entity
@Table(name="planning_work_order_assignment")
@NamedQuery(name="PlanningWorkOrderAssignment.findAll", query="SELECT p FROM PlanningWorkOrderAssignment p")
public class PlanningWorkOrderAssignment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PlanningWorkOrderAssignmentPK id;

	private int actual;

	@Column(name="batch_id")
	private String batchId;

	@Column(name="bom_version")
	private String bomVersion;

	@Column(name="employee_employee_id")
	private int employeeEmployeeId;

	@Temporal(TemporalType.DATE)
	@Column(name="END_TIME")
	private Date endTime;

	private int exptected;

	@Column(name="LINE_ID")
	private int lineId;

	@Column(name="line_line_id")
	private int lineLineId;

	@Column(name="MACHINE_ID")
	private int machineId;

	@Column(name="perform_employee")
	private String performEmployee;

	private int planning;

	@Column(name="planning_work_order_planning_work_order_id")
	private int planningWorkOrderPlanningWorkOrderId;

	@Column(name="QA_EMPLOYEE")
	private String qaEmployee;

	private String sap_batch_Code;

	private int sap_branch_group_Code;

	private int sap_owor_DocEntry;

	@Column(name="sap_work_order")
	private String sapWorkOrder;

	@Temporal(TemporalType.DATE)
	@Column(name="START_TIME")
	private Date startTime;

	private String state;

	private int status;

	@Column(name="WORK_CENTER_ID")
	private int workCenterId;

	public PlanningWorkOrderAssignment() {
	}

	public PlanningWorkOrderAssignmentPK getId() {
		return this.id;
	}

	public void setId(PlanningWorkOrderAssignmentPK id) {
		this.id = id;
	}

	public int getActual() {
		return this.actual;
	}

	public void setActual(int actual) {
		this.actual = actual;
	}

	public String getBatchId() {
		return this.batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getBomVersion() {
		return this.bomVersion;
	}

	public void setBomVersion(String bomVersion) {
		this.bomVersion = bomVersion;
	}

	public int getEmployeeEmployeeId() {
		return this.employeeEmployeeId;
	}

	public void setEmployeeEmployeeId(int employeeEmployeeId) {
		this.employeeEmployeeId = employeeEmployeeId;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getExptected() {
		return this.exptected;
	}

	public void setExptected(int exptected) {
		this.exptected = exptected;
	}

	public int getLineId() {
		return this.lineId;
	}

	public void setLineId(int lineId) {
		this.lineId = lineId;
	}

	public int getLineLineId() {
		return this.lineLineId;
	}

	public void setLineLineId(int lineLineId) {
		this.lineLineId = lineLineId;
	}

	public int getMachineId() {
		return this.machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public String getPerformEmployee() {
		return this.performEmployee;
	}

	public void setPerformEmployee(String performEmployee) {
		this.performEmployee = performEmployee;
	}

	public int getPlanning() {
		return this.planning;
	}

	public void setPlanning(int planning) {
		this.planning = planning;
	}

	public int getPlanningWorkOrderPlanningWorkOrderId() {
		return this.planningWorkOrderPlanningWorkOrderId;
	}

	public void setPlanningWorkOrderPlanningWorkOrderId(int planningWorkOrderPlanningWorkOrderId) {
		this.planningWorkOrderPlanningWorkOrderId = planningWorkOrderPlanningWorkOrderId;
	}

	public String getQaEmployee() {
		return this.qaEmployee;
	}

	public void setQaEmployee(String qaEmployee) {
		this.qaEmployee = qaEmployee;
	}

	public String getSap_batch_Code() {
		return this.sap_batch_Code;
	}

	public void setSap_batch_Code(String sap_batch_Code) {
		this.sap_batch_Code = sap_batch_Code;
	}

	public int getSap_branch_group_Code() {
		return this.sap_branch_group_Code;
	}

	public void setSap_branch_group_Code(int sap_branch_group_Code) {
		this.sap_branch_group_Code = sap_branch_group_Code;
	}

	public int getSap_owor_DocEntry() {
		return this.sap_owor_DocEntry;
	}

	public void setSap_owor_DocEntry(int sap_owor_DocEntry) {
		this.sap_owor_DocEntry = sap_owor_DocEntry;
	}

	public String getSapWorkOrder() {
		return this.sapWorkOrder;
	}

	public void setSapWorkOrder(String sapWorkOrder) {
		this.sapWorkOrder = sapWorkOrder;
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

	public int getWorkCenterId() {
		return this.workCenterId;
	}

	public void setWorkCenterId(int workCenterId) {
		this.workCenterId = workCenterId;
	}

}