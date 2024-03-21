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
 * The persistent class for the pqc_dttd_mount_comp_check database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "pqc_assembles_success")
@NamedQuery(name = "PqcAssemblesSuccessCheck.findAll", query = "SELECT p FROM PqcAssemblesSuccessCheck p")
public class PqcAssemblesSuccessCheck implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "lot_number")
	private String lotNumber;

	@Column(name = "line")
	private String line;

	@Column(name = "process_name")
	private String processName;

	@Column(name = "check_person")
	private String checkPerson;

	@Column(name = "quatity")
	private String quatity;

	@Column(name = "quatity_pass")
	private String quatityPass;

	@Column(name = "quatity_fail")
	private String quatityFail;

	@Column(name = "ratio")
	private String ratio;
	@Column(name = "operators")
	private String operators;

	@Column(name = "conclude")
	private String conclude;

	@Column(name = "note")
	private String note;

	@Column(name = "check_time")
	private String checkTime; 
	
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

	public PqcAssemblesSuccessCheck() {
	}

	@Transient
	List<PqcErrorList> errorLists;

	@ManyToOne(optional = true)
	@JoinColumn(name = "work_order_id", insertable = false, updatable = false)
	@JsonIgnore
	private PqcWorkOrder pqcWorkOrder;

	@OneToMany(mappedBy = "pqcAssemblesSuccessCheck",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcDttdAssemblesError> lstError;
}