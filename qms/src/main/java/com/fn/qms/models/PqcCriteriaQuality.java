package com.fn.qms.models;

import java.io.Serializable;
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
@Table(name="pqc_criteria_quality")
@NamedQuery(name="PqcCriteriaQuality.findAll", query="SELECT p FROM PqcCriteriaQuality p")
public class PqcCriteriaQuality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="template_id")
	private long templateId;

	@Column(name="audit_content")
	private String auditContent;

	@Column(name="regulation_level")
	private String regulationLevel;

	@Column(name="technical_requirement")
	private String technicalRequirement;
	
	@ManyToOne(optional=true)
	@JoinColumn(name = "template_id", insertable=false, updatable=false)
	@JsonIgnore
	private IqcExaminationType iqcExaminationType;
//	
//	@JsonIgnoreProperties({"resultlkdt","hibernateLazyInitializer", "handler"})
//	@OneToMany(mappedBy="criteriaQuality") 
//	private Set<PqcQualityCheck> resultQuality;

	
}