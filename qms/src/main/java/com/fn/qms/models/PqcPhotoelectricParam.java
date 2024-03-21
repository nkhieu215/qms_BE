package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_photoelectric_param database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_photoelectric_param")
@NamedQuery(name="PqcPhotoelectricParam.findAll", query="SELECT p FROM PqcPhotoelectricParam p")

public class PqcPhotoelectricParam  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String avg;

	@Column(name="avg_result")
	private String avgResult;

	@Column(name="check_result")
	private String checkResult;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String kl;

	private String ku;

	private String max;

	private String min;

	private String kmin;
	private String cpk;
	@Column(name =  "cpk_low")
	private String cpkLow;
	@Column(name = "cpk_up")
	private String cpkUp;

	@Column(name="parameter_id")
	private int parameterId;

	@Column(name="pqc_photoelectric_id")
	private Long pqcPhotoelectricId;

	@Column(name="q_avg")
	private String auditQAvg;

	private String quantity;

	private String s;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name =  "parameter_name")
	private String parameterName;
	@Column(name =  "conditions")
	private String conditions;
	@Column(name =  "min_audit")
	private String minAudit;
	@Column(name =  "max_audit")
	private String maxAudit;

	@Column(name =  "unit")
	private String unit;

	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}

	@JsonIgnoreProperties({ "resultParam", "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pqc_photoelectric_id", insertable = false, updatable = false)
	private PqcPhotoelectric pqcPhotoelectric;

}