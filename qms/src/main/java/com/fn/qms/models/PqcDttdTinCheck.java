package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the pqc_dttd_tin_check database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "pqc_dttd_tin_check")
@NamedQuery(name = "PqcDttdTinCheck.findAll", query = "SELECT p FROM PqcDttdTinCheck p")
public class PqcDttdTinCheck implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "dttd_check_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dttdCheckId;

	@Column(name = "batch_id")
	private String batchId;

	@Column(name = "check_person")
	private String checkPerson;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "check_time")
	private String checkTime;

	@Column(name = "machine_code")
	private String machineCode;
	@Column(name = "knife_code")
	private String knifeCode;
	@Column(name = "grid_code")
	private String gridCode;
	
	private String conclude;
	private String operators;

	@Column(name = "err_total")
	private int errTotal;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expiry_date")
	private String expiryDate;

	private String line;

	private String note;

	private int quatity;
	
	private String classify;

	@Column(name = "work_order_id")
	private Long workOrderId;

	public PqcDttdTinCheck() {
	}

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;


	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}

	@OneToMany(mappedBy = "tinCheck",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcDttdTinError> lstError;

	@ManyToOne(optional=true)
	@JoinColumn(name = "work_order_id", insertable=false, updatable=false)
	@JsonIgnore
	private PqcWorkOrder pqcWorkOrder;

	@Transient
	List<PqcErrorList> errorLists;

}