package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the machine database table.
 * 
 */
@Entity
@NamedQuery(name="Machine.findAll", query="SELECT m FROM Machine m")
public class Machine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="machine_id")
	private int machineId;

	@Column(name="line_id")
	private int lineId;

	@Column(name="machine_name")
	private String machineName;

	private int status;

	@Column(name="work_center_id")
	private int workCenterId;

	public Machine() {
	}

	public int getMachineId() {
		return this.machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public int getLineId() {
		return this.lineId;
	}

	public void setLineId(int lineId) {
		this.lineId = lineId;
	}

	public String getMachineName() {
		return this.machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
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