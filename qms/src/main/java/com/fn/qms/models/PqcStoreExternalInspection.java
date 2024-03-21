package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_store_external_inspection database table.
 * 
 */
@Setter
@Getter
@Entity
@Table(name="pqc_store_external_inspection")
@NamedQuery(name="PqcStoreExternalInspection.findAll", query="SELECT p FROM PqcStoreExternalInspection p")
public class PqcStoreExternalInspection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String allow;

	private String conclude;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String reality;

	@Column(name="test_level")
	private String testLevel;

	@Column(name="check_person")
	private String checkPerson;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="work_order_id")
	private Long workOrderId;

	@Column(name="store_check_id")
	private Long storeCheckId;	
	
	@Column(name="note")
	private String note;
	@Column(name="acceptance_level")
	private String acceptanceLevel;

	@Column(name="quantity")
	private Long quantity;

	@PrePersist
	public void create() {
		updatedAt  = createdAt  = new Date();
	}
	
	public PqcStoreExternalInspection() {
	}

}