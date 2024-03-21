package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_store_safe database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_store_safe")
@NamedQuery(name="PqcStoreSafe.findAll", query="SELECT p FROM PqcStoreSafe p")
public class PqcStoreSafe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="check_person")
	private String checkPerson;

	private String conclude;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String note;

	private String quatity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="work_order_id")
	private Long workOrderId;

	@Column(name="store_check_id")
	private Long storeCheckId;
	@Column(name="standard")
	private String standard;

	
	@PrePersist
	public void create() {
		updatedAt  = createdAt  = new Date();
	}
	
	public PqcStoreSafe() {
	}

}