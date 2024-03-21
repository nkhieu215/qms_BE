package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the pqc_photoelectric database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_photoelectric")
@NamedQuery(name="PqcPhotoelectric.findAll", query="SELECT p FROM PqcPhotoelectric p")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class PqcPhotoelectric  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String conclude;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String lot;

	private String note;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="work_order_id")
	private Long workOrderId;
	
	@Column(name="quantity")
	private String quantity;

	@Column(name="created_by",  updatable= false)
	private String createdBy;

	public PqcPhotoelectric() {
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "work_order_id", insertable = false, updatable = false)
	@JsonIgnore
	private PqcWorkOrder pqcWorkOrder;



	@JsonIgnoreProperties(value = { "pqcPhotoelectric" }, allowSetters = true)
	@OneToMany(mappedBy = "pqcPhotoelectric")
	@Fetch(value = FetchMode.SELECT)
	private Set<PqcPhotoelectricLkdt> lstLkdt;
//	
//	

	@JsonIgnoreProperties(value = { "pqcPhotoelectric" }, allowSetters = true)
	@OneToMany(mappedBy = "pqcPhotoelectric")
	@Fetch(value = FetchMode.SELECT)
	private Set<PqcPhotoelectricParam> lstParam;
	
	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}
}