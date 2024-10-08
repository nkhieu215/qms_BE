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
@Table(name="pqc_work_order")
@NamedQuery(name="PqcWorkOrder.findAll", query="SELECT p FROM PqcWorkOrder p")
public class PqcWorkOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="bom_version")
	private String bomVersion;

	private String duyetNhapKho;

	private String ganLK;

	@Column(name = "InKem")
	private String inKem;

	@Column(name="kiemtra_nvl_result")
	private String kiemtraNvlResult;	

	@Column(name="kiemtra_nvl")
	private String kiemTraNvl;

	private String kiemTraLapLan;
	
	private String kimLoai;

	private String KTChiTietNhapKho;

	private String KTLoiSuaLai;

	private String KTQuangDien;

	private String KTQuangDienBTP;

	private String KTQuaTrinhSX;

	private String loHan;

	private String mauDanhGiaCLSP;

	private String nhua;

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
	

	@Column(name = "sap_wo")
	private String sapWo;

	@Column(name = "doc_url")
	private String uDocURL;

	@Column(name = "doc_url2")
	private String uDocURL2;
	
	public PqcWorkOrder() {
	}
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "start_time")
	private String startTime;

	@Column(name = "end_time")
	private String endTime;
	@Column(name = "product_type")
	private Integer productType;

	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}

	@Transient
	String createdDateStr;
	
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
	@OrderBy("createdAt ASC")
	private List<PqcAssemblesSuccessCheck> lstAssembles;


	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcScan100> lstPqcScan100;


	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)	

	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcDrawNvl> lstPqcDrawNvl;
	
	
	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcPhotoelectricProduct> lstPhotoelectricsProduct;
	
	
	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcPhotoelectric> lstPhotoelectrics;
	
	
	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcFixErr> lstFixErr;
	
	@OneToMany(mappedBy = "pqcWorkOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcQuality> lstPqcQcCheck;
}