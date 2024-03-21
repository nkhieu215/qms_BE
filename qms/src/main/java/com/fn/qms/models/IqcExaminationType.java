package com.fn.qms.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * The persistent class for the iqc_examination_type database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "iqc_examination_type")
@NamedQuery(name = "IqcExaminationType.findAll", query = "SELECT i FROM IqcExaminationType i")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class IqcExaminationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String code;

	private String name;

	private int status;

	@Column(name = "type")
	private int type;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_at")
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;	
	
//

	@OneToMany(mappedBy = "examinationTypeNvl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("id")
	private List<IqcAuditCriteriaNvl> lstAuditCriteriaNvl;
//	
	@OneToMany(mappedBy = "iqcExaminationTypeLkdt",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<IqcAuditCriteriaLkdt> lstAuditCriteriaLkdt;
//	
	@OneToMany(mappedBy = "examinationTypeParam",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<IqcAuditCriteriaParameter> iqcAuditCriteriaParameters;
//	
	
	@OneToMany(mappedBy = "iqcExaminationType",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcCriteriaQuality> lstPqcCriteriaQualities;
	
	
	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}

}