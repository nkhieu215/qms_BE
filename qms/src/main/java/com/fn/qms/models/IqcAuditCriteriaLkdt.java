package com.fn.qms.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the iqc_audit_criteria_lkdt database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="iqc_audit_criteria_lkdt")
@NamedQuery(name="IqcAuditCriteriaLkdt.findAll", query="SELECT i FROM IqcAuditCriteriaLkdt i")
public class IqcAuditCriteriaLkdt implements Serializable {
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
	@Column(name = "acceptance_level")
	private String acceptanceLevel;

	@Column(name="technical_requirement")
	private String technicalRequirement;
	
	@ManyToOne(optional=true)
	@JoinColumn(name = "template_id", insertable=false, updatable=false)
	@JsonIgnore
	private IqcExaminationType iqcExaminationTypeLkdt;

}