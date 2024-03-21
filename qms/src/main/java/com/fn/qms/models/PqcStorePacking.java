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
@Table(name="pqc_store_packing")
@NamedQuery(name="PqcStorePacking.findAll", query="SELECT p FROM PqcStorePacking p")
public class PqcStorePacking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="packing")
	private String packing;
	
	@Column(name="tray")
	private String tray;
	@Column(name="check_person")
	private String checkPerson;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="work_order_id")
	private Long workOrderId;
	
	@Column(name="store_check_id")
	private Long storeCheckId;
	
	@Column(name="serial")
	private String serial;
	
	public PqcStorePacking() {
	}

	
	@PrePersist
	public void onCreate() {
		this.createdAt = this.updatedAt = new Date();
	}
}