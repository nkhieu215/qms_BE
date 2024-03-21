package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the line_machine_monitor database table.
 * 
 */
@Entity
@Table(name="line_machine_monitor")
@NamedQuery(name="LineMachineMonitor.findAll", query="SELECT l FROM LineMachineMonitor l")
public class LineMachineMonitor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="line_machine_monitor_id")
	private int lineMachineMonitorId;

	@Column(name="error_quantity")
	private int errorQuantity;

	@Column(name="input_quantity")
	private int inputQuantity;

	@Column(name="line_id")
	private int lineId;

	@Column(name="machine_id")
	private int machineId;

	@Column(name="output_quantity")
	private int outputQuantity;

	@Column(name="planning_work_order_detail_id")
	private int planningWorkOrderDetailId;

	@Column(name="running_time")
	private BigInteger runningTime;

	@Column(name="sap_work_order_id")
	private String sapWorkOrderId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private Date startTime;

	private String state;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="stop_time")
	private Date stopTime;

	public LineMachineMonitor() {
	}

	public int getLineMachineMonitorId() {
		return this.lineMachineMonitorId;
	}

	public void setLineMachineMonitorId(int lineMachineMonitorId) {
		this.lineMachineMonitorId = lineMachineMonitorId;
	}

	public int getErrorQuantity() {
		return this.errorQuantity;
	}

	public void setErrorQuantity(int errorQuantity) {
		this.errorQuantity = errorQuantity;
	}

	public int getInputQuantity() {
		return this.inputQuantity;
	}

	public void setInputQuantity(int inputQuantity) {
		this.inputQuantity = inputQuantity;
	}

	public int getLineId() {
		return this.lineId;
	}

	public void setLineId(int lineId) {
		this.lineId = lineId;
	}

	public int getMachineId() {
		return this.machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public int getOutputQuantity() {
		return this.outputQuantity;
	}

	public void setOutputQuantity(int outputQuantity) {
		this.outputQuantity = outputQuantity;
	}

	public int getPlanningWorkOrderDetailId() {
		return this.planningWorkOrderDetailId;
	}

	public void setPlanningWorkOrderDetailId(int planningWorkOrderDetailId) {
		this.planningWorkOrderDetailId = planningWorkOrderDetailId;
	}

	public BigInteger getRunningTime() {
		return this.runningTime;
	}

	public void setRunningTime(BigInteger runningTime) {
		this.runningTime = runningTime;
	}

	public String getSapWorkOrderId() {
		return this.sapWorkOrderId;
	}

	public void setSapWorkOrderId(String sapWorkOrderId) {
		this.sapWorkOrderId = sapWorkOrderId;
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

	public Date getStopTime() {
		return this.stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

}