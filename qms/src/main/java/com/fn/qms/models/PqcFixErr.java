package com.fn.qms.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the pqc_fix_err database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_fix_err")
@NamedQuery(name="PqcFixErr.findAll", query="SELECT p FROM PqcFixErr p")
public class PqcFixErr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="err_gr")
	private String errGr;

	@Column(name="err_name")
	private String errName;

	@Column(name="note")
	private String note;

	@Column(name="quantity")
	private String quantity;

	@Column(name="ratio")
	private String ratio;

	@Column(name="serial")
	private String serial;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="user_id")
	private String userId;

	@Column(name="work_order_id")
	private Long workOrderId;
	
	@Column(name="quantity_err")
	private String quantityErr;
	

	@Column(name="lot_number")
	private String lotNumber;

	@Column(name="stage")
	private String stage;

	@Column(name="materials")
	private String materials;
	
	public PqcFixErr() {
	}

	@PrePersist
	public void create() {
		updatedAt  = createdAt  = new Date();
	}
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "work_order_id", insertable = false, updatable = false)
	@JsonIgnore
	private PqcWorkOrder pqcWorkOrder;

}