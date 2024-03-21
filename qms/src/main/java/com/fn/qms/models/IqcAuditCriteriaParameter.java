package com.fn.qms.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the iqc_parameter database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "iqc_audit_criteria_parameter")
@NamedQuery(name = "IqcAuditCriteriaParameter.findAll", query = "SELECT i FROM IqcAuditCriteriaParameter i")
public class IqcAuditCriteriaParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "template_id")
	private long templateId;

	private String conditions;

	private Double max;

	private Double min;

	@Column(name = "parameter_name")
	private String parameterName;

	private String unit;

	@ManyToOne(optional=true)
	@JoinColumn(name = "template_id", insertable=false, updatable=false)
	@JsonIgnore
	private IqcExaminationType examinationTypeParam;
	
	@JsonIgnoreProperties({"auditCriteriaParam","hibernateLazyInitializer", "handler"})
	@OneToMany(mappedBy="auditCriteriaParam") 
	private Set<IqcAuditResultParameter> resultParam;
}