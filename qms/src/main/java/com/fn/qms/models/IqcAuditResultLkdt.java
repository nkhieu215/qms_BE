package com.fn.qms.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the iqc_audit_result_lkdt database table.
 * 
 */
@Setter
@Getter
@Entity
@Table(name="iqc_audit_result_lkdt")
@NamedQuery(name="IqcAuditResultLkdt.findAll", query="SELECT i FROM IqcAuditResultLkdt i")
public class IqcAuditResultLkdt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name="audit_critetia_lkdt_id")
	private int auditCritetiaLkdtId;

	@Column(name="check_content")
	private String checkContent;

	@Column(name="check_result")
	private String checkResult;

	@Column(name="elect_comp_id")
	private Long electCompId;

	private String inaccuracy;

	private String quantity;

	@Transient
	private String auditQuantity;


	@Column(name="audit_content")
	private String auditContent;

	@Column(name="technical_requirement")
	private String technicalRequirement;

	@Column(name="regulation_level")
	private String regulationLevel;
	@Column(name = "acceptance_level")
	private String acceptanceLevel;

	@Column(name="created_at")
	private Date createdAt;


	@Column(name="updated_at")
	private Date updatedAt;
	//
	@ManyToOne(optional = true)
	@JoinColumn(name = "elect_comp_id", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "resultLkdt", "hibernateLazyInitializer", "handler" })
	private IqcElectronicComponent electronicComponent;
	

	@PrePersist
	void onCreate(){
		this.createdAt = this.updatedAt =  new Date();
	}

}