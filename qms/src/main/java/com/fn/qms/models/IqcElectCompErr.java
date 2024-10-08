package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the iqc_elect_comp_err database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="iqc_elect_comp_err")
@NamedQuery(name="IqcElectCompErr.findAll", query="SELECT i FROM IqcElectCompErr i")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class IqcElectCompErr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name="err_group")
	private String errGroup;

	@Column(name="err_name")
	private String errName;
	@Column(name="err_code")
	private String errCode;
	@Column(name="created_at")
	private String createdAt;
	@Column(name="note")
	private String note;
	private int quantity;

	@Column(name="elect_comp_id")
	private Long electCompId;
	@Column(name="audit_result_item_id")
	private Integer auditResultItemId;

	private String ratio;

	//bi-directional many-to-one association to IqcElectronicComponent
	@ManyToOne(optional=true)
	@JoinColumn(name = "elect_comp_id", insertable=false, updatable=false)
	private IqcElectronicComponent iqcElectronicComponent;
}