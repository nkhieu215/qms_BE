package com.fn.qms.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pqc_work_order database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="approve_store_sap")
@NamedQuery(name="ApproveStoreSap.findAll", query="SELECT p FROM ApproveStoreSap p")
public class ApproveStoreSap implements Serializable {
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

	public ApproveStoreSap() {
	}
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "start_time")
	private String startTime;

	@Column(name = "end_time")
	private String endTime;

	@Column(name = "status_approve_sap")
	private String statusApproveSap;
	@Column(name = "quatity_store")
	private String quatityStore;

	@Column(name = "store_id")
	private Long storeId;

	@Column(name = "date_store")
	private Date dateStore;
}