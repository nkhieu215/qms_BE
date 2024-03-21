package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_draw_test_nvl database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_draw_test_nvl")
@NamedQuery(name="PqcDrawTestNvl.findAll", query="SELECT p FROM PqcDrawTestNvl p")
public class PqcDrawTestNvl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="allow_result")
	private String allowResult;
	
	@Column(name="check_date")
	private String checkDate;

	@Column(name="external_inspection")
	private String externalInspection;

	@Column(name="item_code")
	private String itemCode;

	@Column(name="item_name")
	private String itemName;

	private String lot;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="manufacture_date")
	private Date manufactureDate;

	@Column(name="max_cosfi")
	private String maxCosfi;

	@Column(name="max_electric")
	private String maxElectric;

	@Column(name="max_power")
	private String maxPower;

	@Column(name="min_cosfi")
	private String minCosfi;

	@Column(name="min_electric")
	private String minElectric;

	@Column(name="min_power")
	private String minPower;

	private String note;

	@Column(name="part_number")
	private String partNumber;

	@Column(name="po_code")
	private String poCode;

	private String qty;

	@Column(name="rank_ap")
	private String rankAp;

	@Column(name="rank_mau")
	private String rankMau;

	@Column(name="rank_quang")
	private String rankQuang;

	@Column(name="real_result")
	private String realResult;

	@Column(name="regulation_check")
	private String regulationCheck;

	@Column(name="sample_quantity")
	private String sampleQuantity;

	@Column(name="technical_para")
	private String technicalPara;
	@Column(name="param_max")
	private String paramMax;
	@Column(name="param_min")
	private String paramMin;
	@Column(name="unit")
	private String unit;
	@Column(name="return_day")
	private String returnDay;
	private String vendor;

	@Column(name="work_order_id")
	private Long workOrderId;
	
	@Column(name="pqc_draw_nvl_id")
	private Long pqcDrawNvlId;

	@ManyToOne(optional = true)
	@JoinColumn(name = "pqc_draw_nvl_id", insertable = false, updatable = false)
	@JsonIgnore
	private PqcDrawNvl drawNvlCheck;
//
//	@JsonManagedReference
//	@ManyToOne(optional = true)
//	@JoinColumn(name = "pqc_draw_nvl_id", insertable = false, updatable = false)
//	@JsonIgnore
//	private PqcDrawNvl drawNvl;

	public PqcDrawTestNvl() {
	}

}