package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_store_pow database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_store_pow")
@NamedQuery(name="PqcStorePow.findAll", query="SELECT p FROM PqcStorePow p")
public class PqcStorePow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String conclude;

	@Column(name="cos_fi")
	private String cosFi;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Column(name="elec_check")
	private String elecCheck;
	@Column(name="check_person")
	private String checkPerson;

	private String note;

	@Column(name="pow_check")
	private String powCheck;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="work_order_id")
	private Long workOrderId;
	
	@Column(name="store_check_id")
	private Long storeCheckId;

	@Column(name="status")
	private Integer status;

	@Column(name="quantity_check")
	private Long quantityCheck;

	public PqcStorePow() {
	}

	
	@PrePersist
	public void onCreate() {
		this.createdAt = this.updatedAt = new Date();
	}
}