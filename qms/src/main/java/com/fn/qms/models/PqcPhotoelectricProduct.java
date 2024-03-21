package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_photoelectric_product database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_photoelectric_product")
@NamedQuery(name="PqcPhotoelectricProduct.findAll", query="SELECT p FROM PqcPhotoelectricProduct p")
public class PqcPhotoelectricProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="check_person")
	private String checkPerson;

	@Column(name="coefficient_wattage_max")
	private String coefficientWattageMax;

	@Column(name="coefficient_wattage_min")
	private String coefficientWattageMin;

	@Column(name="color_max")
	private String colorMax;

	@Column(name="color_min")
	private String colorMin;

	@Column(name="color_temp_max")
	private String colorTempMax;

	@Column(name="color_temp_min")
	private String colorTempMin;

	private String conclude;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Column(name="ectric_max")
	private String ectricMax;

	@Column(name="ectric_min")
	private String ectricMin;

	@Column(name="note")
	private String note;

	@Column(name="performance_max")
	private String performanceMax;

	@Column(name="performance_min")
	private String performanceMin;

	private String pow;

	@Column(name="pow_max")
	private String powMax;

	@Column(name="pow_min")
	private String powMin;

	private String quatity;

	private String ratio;

	private String tbn;

	private String temp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="wattage_max")
	private String wattageMax;

	@Column(name="wattage_min")
	private String wattageMin;
	@Column(name="sdcm_max")
	private String sdcmMax;
	@Column(name="sdcm_min")
	private String sdcmMin;
	

	@Column(name="lot_number")
	private String lotNumber;

	@Column(name="pow_supply_max")
	private String powSupplyMax;

	@Column(name="pow_supply_min")
	private String powSupplyMin;

	@Column(name="work_order_id")
	private Long workOrderId;

	@Transient
	String createdAtStr;

	public PqcPhotoelectricProduct() {
	}
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "work_order_id", insertable = false, updatable = false)
	@JsonIgnore
	private PqcWorkOrder pqcWorkOrder;

	@PrePersist
	private void onCreate(){
		this.updatedAt = this.createdAt = new Date();
	}
}