package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the profile database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "pqc_quality_check")
@NamedQuery(name = "PqcQualityCheck.findAll", query = "SELECT p FROM PqcQualityCheck p")
public class PqcQualityCheck implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "note")
	private String note;

	@Column(name = "conclude")
	private String conclude;

	@Column(name = "quality_id")
	private Long qualityId;
	
	@Column(name = "template_id")
	private Long templateId;
	
	@Column(name = "invalid_number")
	private Long invalidNumber;
	
	@Column(name = "work_order_id")
	private Long workOrderId;
	
//	@ManyToOne(optional=true)
//	@JoinColumn(name = "template_id", insertable=false, updatable=false)
//	@JsonIgnore
//	private PqcCriteriaQuality criteriaQuality;
	
//	@ManyToOne(optional=true)
//	@JoinColumn(name = "quality_id", insertable=false, updatable=false)
//	@JsonIgnore
//	private PqcQuality pqcQuality;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name="audit_content")
	private String auditContent;

	@Column(name="regulation_level")
	private String regulationLevel;

	@Column(name="technical_requirement")
	private String technicalRequirement;
	
	@PrePersist
	public void create() {
		updatedAt  = createdAt  = new Date();
	}
	
}