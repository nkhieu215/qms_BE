package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the line database table.
 * 
 */
@Entity
@NamedQuery(name="Line.findAll", query="SELECT l FROM Line l")
public class Line implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="line_id")
	private int lineId;

	@Column(name="error_ratio")
	private float errorRatio;

	@Column(name="input_quantity")
	private int inputQuantity;

	@Column(name="line_machine_monitor_line_machine_monitor_id")
	private int lineMachineMonitorLineMachineMonitorId;

	@Column(name="line_name")
	private String lineName;

	private String location;

	private String performance;

	private String status;

	@Column(name="work_center_id")
	private int workCenterId;

	public Line() {
	}

	public int getLineId() {
		return this.lineId;
	}

	public void setLineId(int lineId) {
		this.lineId = lineId;
	}

	public float getErrorRatio() {
		return this.errorRatio;
	}

	public void setErrorRatio(float errorRatio) {
		this.errorRatio = errorRatio;
	}

	public int getInputQuantity() {
		return this.inputQuantity;
	}

	public void setInputQuantity(int inputQuantity) {
		this.inputQuantity = inputQuantity;
	}

	public int getLineMachineMonitorLineMachineMonitorId() {
		return this.lineMachineMonitorLineMachineMonitorId;
	}

	public void setLineMachineMonitorLineMachineMonitorId(int lineMachineMonitorLineMachineMonitorId) {
		this.lineMachineMonitorLineMachineMonitorId = lineMachineMonitorLineMachineMonitorId;
	}

	public String getLineName() {
		return this.lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPerformance() {
		return this.performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getWorkCenterId() {
		return this.workCenterId;
	}

	public void setWorkCenterId(int workCenterId) {
		this.workCenterId = workCenterId;
	}

}