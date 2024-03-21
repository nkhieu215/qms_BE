package com.fn.qms.rest;

import java.util.List;

import com.fn.qms.models.PqcAssemblesSuccessCheck;
import com.fn.qms.models.PqcDrawNvl;
import com.fn.qms.models.PqcDttdInterchangeabilityCheck;
import com.fn.qms.models.PqcDttdMountCompCheck;
import com.fn.qms.models.PqcDttdSolderCheck;
import com.fn.qms.models.PqcDttdTinCheck;
import com.fn.qms.models.PqcFixErr;
import com.fn.qms.models.PqcPhotoelectric;
import com.fn.qms.models.PqcPhotoelectricProduct;
import com.fn.qms.models.PqcQuality;
import com.fn.qms.models.PqcStoreCheck;
import com.fn.qms.models.PqcStoreConfused;
import com.fn.qms.models.PqcStoreErr;
import com.fn.qms.models.PqcStoreExternalInspection;
import com.fn.qms.models.PqcStorePow;
import com.fn.qms.models.PqcStoreSafe;
import com.fn.qms.models.PqcStoreSize;
import com.fn.qms.models.PqcStoreStructure;
import com.fn.qms.planning.model.UserWorkOrder;
import com.fn.qms.rest.bean.WorkOder;

import com.fn.sap.models.Citt1;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductionStepRequest extends BaseRequest {
	private String code;
	private String idOrder;
	private String idProfile;
	private String sap;
	private String action; // action thuc hien
	private String step; // buoc thuc hien
	private String woCode;
	private String productCode;
	private WorkOder data;
	private String status;
	// thong tin linh kien sx
	private List<Citt1> bomversion;
	// thong tin user va cac buoc
	private List<UserWorkOrder> lstUserDetail;
	private String startDate;
	private String endDate;

	private String groupName;
	private String branchName;
	

	Long workOrderId;
	List<PqcDrawNvl> lstNvl;
	List<PqcDttdTinCheck> lstTin;	
	List<PqcDttdMountCompCheck> lstMountCheck;
	List<PqcDttdSolderCheck> lstSolder;
	List<PqcDttdInterchangeabilityCheck> lstInter; //  kiem tra lap lan
	List<PqcAssemblesSuccessCheck> lstAssembles; // kiem tra lap hoan chinh
	List<PqcPhotoelectric> lstPhotoelectrics; // quang dien
	List<PqcPhotoelectricProduct> lstPhotoelectricProducts ; // quang dien sp
	List<PqcFixErr> lstFixError; // sua loi
	
	List<PqcStoreCheck> lstCheckStore;
	List<PqcStoreConfused> lstStoreCheckConfuseds;
	List<PqcStoreErr> lstErrs;
	List<PqcStoreExternalInspection> lstExternalInspections;
	List<PqcStorePow> lstPows;
	List<PqcStoreSafe> lstPqcStoreSafes;
	List<PqcStoreSize> lstPqcStoreSizes;
	List<PqcStoreStructure> lstPqcStoreStructures;
 	
	List<PqcQuality> lstPqcQualities;
	
	List<Object> lstQcCheck;
	Object approveStore;
}
