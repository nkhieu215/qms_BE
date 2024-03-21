package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the pqc_dttd_mount_comp_check database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "pqc_dttd_interchangeability")
@NamedQuery(name = "PqcDttdInterchangeabilityCheck.findAll", query = "SELECT p FROM PqcDttdInterchangeabilityCheck p")
public class PqcDttdInterchangeabilityCheck implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "lot")
	private String lot;

	@Column(name = "line")
	private String line;
//	
	@Column(name = "check_person")
	private String checkPerson;

	@Column(name = "check_time")
	private String checkTime;

	@Column(name = "quatity")
	private int quatity;
	@Column(name = "operators")
	private String operators;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "external_inspection")
	private String externalInspection;

	@Column(name = "pow_min")
	private String powMin;

	@Column(name = "pow_max")
	private String powMax;

	@Column(name = "fi_min")
	private String fiMin;

	@Column(name = "fi_max")
	private String fiMax;

	@Column(name = "elec_min")
	private String elecMin;
	@Column(name = "elec_max")
	private String elecMax;

	@Column(name = "conclude")
	private String conclude;
	@Column(name = "note")
	private String note;
	@Column(name = "total")
	private String total;

	@Column(name = "work_order_id")
	private Long workOrderId;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}

	public PqcDttdInterchangeabilityCheck() {
	}

	@Transient
	List<PqcErrorList> errorLists;

	@ManyToOne(optional = true)
	@JoinColumn(name = "work_order_id", insertable = false, updatable = false)
	@JsonIgnore
	private PqcWorkOrder pqcWorkOrder;

}