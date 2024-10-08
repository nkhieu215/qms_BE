package com.fn.qms.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the pqc_error_list database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_quality")
@NamedQuery(name="PqcQuality.findAll", query="SELECT p FROM PqcQuality p")
public class PqcQuality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="check_persion")
	private String checkPersion;

	@Column(name="work_order_id")
	private Long workOrderId;

	@Column(name="note")
	private String note;

	@Column(name="conclude")
	private String conclude;
	
	@Column(name="quantity")
	private String quantity;
	@Column(name = "checked")
	private String checked;
//
//	@JsonIgnoreProperties({"resultlkdt","hibernateLazyInitializer", "handler"})
//	@OneToMany(mappedBy="pqcQuality")
	@Transient
	public List<PqcQualityCheck> lstCheck;

	@ManyToOne(optional = true)
	@JoinColumn(name = "work_order_id", insertable = false, updatable = false)
	@JsonIgnore
	private PqcWorkOrder pqcWorkOrder;

	
//	@Transient
//	List<PqcQualityCheck> lstCheck;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at",  updatable= false)
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@PrePersist
	public void create() {
		updatedAt  = createdAt  = new Date();
	}

	@PreUpdate
	protected void update() {
		updatedAt = new Date();
	}
	
}