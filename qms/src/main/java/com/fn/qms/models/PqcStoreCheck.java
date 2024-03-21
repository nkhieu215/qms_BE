package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the pqc_store_check database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "pqc_store_check")
@NamedQuery(name = "PqcStoreCheck.findAll", query = "SELECT p FROM PqcStoreCheck p")
public class PqcStoreCheck implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "check_date")
	private String checkDate;

	@Column(name = "check_person")
	private String checkPerson;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private String lot;

	private String quatity;

	@Column(name = "quatity_store")
	private String quatityStore;

	@Column(name = "total_err")
	private String totalErr;

	@Column(name = "note")
	private String note;
	@Column(name = "quantity_store_sap")
	private String quantityStoreSap;
	@Column(name = "date_approve_sap")
	private String dateApproveSap;

	@Column(name = "note_approve")
	private String noteApprove;

	@Column(name = "his_string")
	private String hisString;
	@Column(name = "conclude")
	private String conclude;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "work_order_id")
	private Long workOrderId;

	@Column(name = "status")
	private Integer status;

	@Column(name = "status_approve_sap")
	private String statusApproveSap;

	@Column(name = "id_approve_planing")
	private String idApprovePlaning;
	@Column(name = "color_name")
	private String colorName;

	@Column(name = "color_Code")
	private String colorCode;

	public PqcStoreCheck() {
	}

	@PrePersist
	public void create() {
		updatedAt  = createdAt  = new Date();
	}
	
	@Transient
	List<PqcStoreConfused> lstConfused;
	@Transient
	List<PqcStoreErr> lstPqcStoreErrs;
	@Transient
	List<PqcStoreExternalInspection> lstExternalInspections;
	@Transient
	List<PqcStorePow> lsPows;
	@Transient
	List<PqcStoreSafe> lsPqcStoreSafes;
	@Transient
	List<PqcStoreSize> lsSizes;
	@Transient
	List<PqcStoreConfused> lstConfuseds;
	@Transient
	List<PqcStoreStructure> pqcStoreStructures;

	@Transient
	String statusSap;
}