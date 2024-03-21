package com.fn.qms.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

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
@Table(name="iqc_parameter_audit_result")
@NamedQuery(name="IqcParameterAuditResult.findAll", query="SELECT i FROM IqcParameterAuditResult i")
public class IqcParameterAuditResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="parameter_audit_result_id")
	private int parameterAuditResultId;

	private float avg;

	@Column(name="check_result")
	private String checkResult;

	private String content;

	private String kl;

	private String ku;

	private float max;

	private float min;

	@Column(name="q_avg")
	private String qAvg;

	private int quantity;

	private String s;


}