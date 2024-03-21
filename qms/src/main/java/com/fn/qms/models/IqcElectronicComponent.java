package com.fn.qms.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The persistent class for the iqc_electronic_component database table.
 * 
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "iqc_electronic_component")
@NamedQuery(name = "IqcElectronicComponent.findAll", query = "SELECT i FROM IqcElectronicComponent i")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class IqcElectronicComponent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "elec_comp_code")
	private String elecCompCode;

	@Column(name = "elect_comp_name")
	private String electCompName;

	@Column(name = "po_quantity")
	private String poQuantity;

	@Temporal(TemporalType.DATE)
	@Column(name = "import_date")
	private Date importDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "check_date")
	private Date checkDate;

	@Column(name = "invoice_number")
	private String invoiceNumber;

	@Column(name = "origin")
	private String origin;

	@Column(name = "grpo_number")
	private String grpoNumber;

	@Column(name = "checking_quantity")
	private int checkingQuantity;

	@Column(name = "spkph_number")
	private String spkphNumber;

	private String conclusion;

	@Column(name = "report_code")
	private String reportCode;

	@Column(name = "status")
	private String status;

	@Column(name = "create_by")
	private String createBy;

	@Column(name = "aprove_by")
	private String aproveBy;

	@Column(name = "note")
	private String note;

	@Column(name = "batch_number")
	private String batchNumber;


	@Column(name = "created_at")
	private Date createdAt;


	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "item_type")
	private String itemType;

	@Column(name = "type")
	private String type;
	@Column(name = "template_code")
	private String templateCode;

	@Column(name = "approve_note")
	private String approveNote;

	@JsonIgnoreProperties(value = { "electronicComponent" }, allowSetters = true)
	@OneToMany(mappedBy = "electronicComponent", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("id")
	private Set<IqcAuditResultNvl> resultNvls;

	@JsonIgnoreProperties(value ={ "iqcElectronicComponent" }, allowSetters = true)
	@OneToMany(mappedBy = "iqcElectronicComponent", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SELECT)
	private Set<IqcElectCompErr> resultError;
	

	@JsonIgnoreProperties(value ={ "electronicComponent" }, allowSetters = true)
	@OneToMany(mappedBy = "electronicComponent", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SELECT)
	@OrderBy("id")
	private Set<IqcAuditResultLkdt> resultLkdt;
	

	@JsonIgnoreProperties(value ={ "electronicComponent" }, allowSetters = true)
	@OneToMany(mappedBy = "electronicComponent", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SELECT)
	@OrderBy("id")
	private Set<IqcAuditResultParameter> resultParam;

//	

	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}



}