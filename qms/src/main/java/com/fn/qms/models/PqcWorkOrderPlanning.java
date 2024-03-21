package com.fn.qms.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;



/**
 * The persistent class for the pqc_work_order database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_work_order_planning")
@NamedQuery(name="PqcWorkOrderPlanning.findAll", query="SELECT p FROM PqcWorkOrderPlanning p")
public class PqcWorkOrderPlanning implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="bom_version")
	private String bomVersion;
	
	@Column(name="planing_work_order_code")
	private String planingWorkOrderCode;

	@Column(name="planing_work_order_id")
	private int planingWorkOrderId;

	@Column(name="production_code")
	private String productionCode;

	@Column(name="production_name")
	private String productionName;
	
	@Column(name="purchase_order_code")
	private String purchaseOrderCode;

	@Column(name="rut_nghiem")
	private String rutNghiem;
	

	@Column(name="lot_number")
	private String lotNumber;

	@Column(name="rutnghiem_nvl_result")
	private String rutnghiemNvlResult;

	private String son;

	@Column(name="work_order_id")
	private String workOrderId;

	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="status")
	private String status;
	
	@Column(name="quantity_plan")
	private String quantityPlan;
	
	@Column(name="branch_name")
	private String branchName;
	
	@Column(name="group_name")
	private String groupName;
	
	

	@Column(name = "profile_id")
	private String profileId;

	@Column(name = "profile_name")
	private String profileName;

	@Column(name = "profile_code")
	private String profileCode;
	
	public PqcWorkOrderPlanning() {
	}
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;	
	
	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}

	
	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)	

	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcBomWorkorder> lstbom;
	
	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)	

	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcDttdMountCompCheck> lstMount;	
	
	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)	

	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcDttdSolderCheck> lstSolder;
	
	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)	

	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcDttdTinCheck> lstTin;
	
	@OneToMany(mappedBy = "pqcWorkOrderP",fetch = FetchType.EAGER, cascade = CascadeType.ALL)	

	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcWorkOrderStepStatus> lstStatusStep;
	
	
	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)	

	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcDttdInterchangeabilityCheck> lstInter;
	
	
	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)	

	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcAssemblesSuccessCheck> lstAssembles;
	
	
//	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)	
//
//	@Fetch(value = FetchMode.SUBSELECT)
//	private List<PqcDrawNvl> lstPqcDrawNvl;
	
	
	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)	

	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcPhotoelectricProduct> lstPhotoelectricsProduct;
	
	
	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)	

	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcPhotoelectric> lstPhotoelectrics;
	
	
	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)	

	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcFixErr> lstFixErr;
}