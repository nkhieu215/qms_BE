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
@Table(name="pqc_dttd_mount_comp_check")
@NamedQuery(name="PqcDttdMountCompCheck.findAll", query="SELECT p FROM PqcDttdMountCompCheck p")
public class PqcDttdMountCompCheck implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dttd_mount_comp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dttdMountCompId;

	@Column(name="batch_id")
	private String batchId;

	@Column(name="check_person")
	private String checkPerson;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="check_time")
	private String checkTime;

	private String conclude;

	@Column(name="err_total")
	private int errTotal;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expiry_date")
	private String expiryDate;

	@Column(name="operators")
	private String operators;

	private String line;

	@Column(name="machine_name")
	private String machineName;

	private String note;

	private int quatity;

	@Column(name="work_order_id")
	private Long workOrderId;

	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;	
	
	
	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}
	
	public PqcDttdMountCompCheck() {
	}

	@OneToMany(mappedBy = "mountCompCheck",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcDttdMountError> lstError;
	
	@ManyToOne(optional=true)
	@JoinColumn(name = "work_order_id", insertable=false, updatable=false)
	@JsonIgnore
	private PqcWorkOrder pqcWorkOrder;
	
}