package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class WoDTO {
    private Long id;
    private String bomVersion;
    private String duyetNhapKho;
    private String ganLK;
    private String inKem;
    private String kiemtraNvlResult;
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
    private String planingWorkOrderCode;
    private int planingWorkOrderId;
    private String productionCode;
    private String productionName;
    private String purchaseOrderCode;
    private String rutNghiem;
    private String lotNumber;
    private String rutnghiemNvlResult;
    private String son;
    private String workOrderId;
    private String createdBy;
    private String status;
    private String statusSuccess;
    private String quantityPlan;
    private String branchName;
    private String groupName;
    private String profileId;
    private String profileName;
    private String profileCode;
    private String sapWo;
    private Date createdAt;
    private Date updatedAt;
    private String uDocURL;
    private String uDocURL2;
    private Long storeId;
    private String statusApproveSap;
    private String quatityStore;
    private Date dateStore;

    private String total;
    private String totalSap;
    private List<BomWorkOrderDTO> lstbom;
    private List<MountCheckDTO> lstMount;
    private List<SolderCheckDTO> lstSolder;
    private List<TinCheckDTO> lstTin;
    private List<OrderStepStatusDTO> lstStatusStep;
    private List<InterchangeabilityCheckDTO> lstInter;
    private List<AssemblesSuccessCheckDTO> lstAssembles;
    private List<PqcDrawNvlDTO> lstPqcDrawNvl;
    private List<PqcPhotoelectricProductDTO> lstPhotoelectricsProduct;
    private List<PqcPhotoelectricDTO> lstPhotoelectrics;
    private List<PqcFixErrDTO> lstFixErr;
    private List<PqcQualityDTO> lstPqcQcCheck;
    
    private List<Scan100DTO> lstPqcScan100;
}
