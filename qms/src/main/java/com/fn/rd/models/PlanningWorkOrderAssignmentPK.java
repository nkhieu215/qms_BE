package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the planning_work_order_assignment database table.
 * 
 */
@Embeddable
public class PlanningWorkOrderAssignmentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PLANNING_DETAIL_ID")
	private int planningDetailId;

	@Column(name="machine_machine_id")
	private int machineMachineId;

	public PlanningWorkOrderAssignmentPK() {
	}
	public int getPlanningDetailId() {
		return this.planningDetailId;
	}
	public void setPlanningDetailId(int planningDetailId) {
		this.planningDetailId = planningDetailId;
	}
	public int getMachineMachineId() {
		return this.machineMachineId;
	}
	public void setMachineMachineId(int machineMachineId) {
		this.machineMachineId = machineMachineId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PlanningWorkOrderAssignmentPK)) {
			return false;
		}
		PlanningWorkOrderAssignmentPK castOther = (PlanningWorkOrderAssignmentPK)other;
		return 
			(this.planningDetailId == castOther.planningDetailId)
			&& (this.machineMachineId == castOther.machineMachineId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.planningDetailId;
		hash = hash * prime + this.machineMachineId;
		
		return hash;
	}
}