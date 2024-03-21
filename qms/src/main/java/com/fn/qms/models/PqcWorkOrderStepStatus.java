package com.fn.qms.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the pqc_work_order database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "pqc_step_status")
@NamedQuery(name = "PqcWorkOrderStepStatus.findAll", query = "SELECT p FROM PqcWorkOrderStepStatus p")
public class PqcWorkOrderStepStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "pqc_work_order")
	private Long pqcWorkOrder;
	@Column(name = "position")
	private Long position;
	@Column(name = "user_id")
	private String userId;
	@Column(name = "status")
	private String status;
	@Column(name = "step")
	private String step;
	public PqcWorkOrderStepStatus() {
	}
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;
	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}
	
	@ManyToOne(optional=true)
	@JoinColumn(name = "pqc_work_order", insertable=false, updatable=false)
	@JsonIgnore
	private PqcWorkOrder pqcWorkOrderP;

}