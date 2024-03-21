package com.fn.qms.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the roles database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="step_process")
@NamedQuery(name="StepProcess.findAll", query="SELECT r FROM StepProcess r")
public class StepProcess implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="name")
	private String name;
	@Column(name="type")
	private String type;
	@Column(name="label")
	private String label;
	@Column(name="description")
	private String description;
	@Column(name="id_stage")
	private String idStage;
	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@PrePersist
	public void create() {
		createdAt  = new Date();
	}
}