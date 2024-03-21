package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the iqc_parameter_audit_result database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="iqc_audit_result_parameter")
@NamedQuery(name="IqcAuditResultParameter.findAll", query="SELECT i FROM IqcAuditResultParameter i")
public class IqcAuditResultParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="avg")
	private String avg;

	@Column(name="check_result")
	private String checkResult;
	@Column(name =  "content")
	private String content;
	@Column(name =  "kl")
	private String kl;
	@Column(name =  "ku")
	private String ku;
	@Column(name =  "max")
	private String max;
	@Column(name =  "min")
	private String min;
	@Column(name =  "min_audit")
	private String minAudit;
	@Column(name =  "max_audit")
	private String maxAudit;
	@Column(name =  "kmin")
	private String kmin;
	@Column(name =  "cpk")
	private String cpk;
	@Column(name =  "cpk_low")
	private String cpkLow;
	@Column(name = "cpk_up")
	private String cpkUp;
	@Column(name="q_avg")
	private String QAvg;
	@Column(name="quantity")
	private String quantity;
	@Column(name="s")
	private String s;
	@Column(name="avg_Result")
	private String avgResult;
	@Column(name="elect_comp_id")
	private Long electCompId;
	
	@Column(name="parameter_id")
	private Long parameterId;
	@Column(name="parameter_name")
	private String parameterName;
	@Column(name="conditions")
	private String conditions;
	@Column(name="unit")
	private String unit;

	@Column(name="data")
	private String data;


	@Transient
	private String auditAvg;
	@Transient
	private String auditQAvg;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "elect_comp_id", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "resultParam", "hibernateLazyInitializer", "handler" })
	private IqcElectronicComponent electronicComponent;

	@JsonIgnoreProperties({ "resultParam", "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parameter_id", insertable = false, updatable = false)
	private IqcAuditCriteriaParameter auditCriteriaParam;
	
}