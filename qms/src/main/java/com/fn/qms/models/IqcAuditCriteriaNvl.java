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
 * The persistent class for the iqc_audit_criteria_nvl database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "iqc_audit_criteria_nvl")
@NamedQuery(name = "IqcAuditCriteriaNvl.findAll", query = "SELECT i FROM IqcAuditCriteriaNvl i")
public class IqcAuditCriteriaNvl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "template_id")
	private long templateId;

	@Column(name = "criteria_name")
	private String criteriaName;

	private String max;

	private String min;

	private String note;

	@Column(name = "regulation_level")
	private String regulationLevel;
	@Column(name = "acceptance_level")
	private String acceptanceLevel;

	private String unit;
//
	@ManyToOne(optional=true)
	@JoinColumn(name = "template_id", insertable=false, updatable=false)
	@JsonIgnore
	private IqcExaminationType examinationTypeNvl;

}