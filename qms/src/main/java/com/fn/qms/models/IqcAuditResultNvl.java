package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the iqc_audit_result_nvl database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "iqc_audit_result_nvl")
@NamedQuery(name = "IqcAuditResultNvl.findAll", query = "SELECT i FROM IqcAuditResultNvl i")
public class IqcAuditResultNvl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "approve_status")
	private String approveStatus;

	@Column(name = "audit_criteria_id")
	private Long auditCriteriaId;

	@Column(name = "check_result")
	private String checkResult;

	@Column(name = "elect_comp_id")
	private Long electCompId;

	@Column(name = "item_type")
	private String itemType;

	private float max;

	private float min;

	private String note;

	@Column(name = "orther_requerement")
	private String ortherRequerement;

	private String quantity;

	private String unit;

	//
	@ManyToOne(optional = true)
	@JoinColumn(name = "elect_comp_id", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "resultNvls", "hibernateLazyInitializer", "handler" })
	private IqcElectronicComponent electronicComponent;


	@Column(name = "min_audit")
	private String minAudit;
	@Column(name = "max_audit")
	private String maxAudit;
	@Column(name = "unit_audit")
	private String unitAudit;
	@Column(name = "note_audit")
	private String noteAudit;
	@Column(name = "criteria_name")
	private String criteriaName;
	@Column(name = "regulation_level")
	private String regulationLevel;
	@Column(name = "acceptance_level")
	private String acceptanceLevel;
}