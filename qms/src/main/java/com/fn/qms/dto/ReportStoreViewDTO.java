package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class ReportStoreViewDTO {
    private Long id;
    private String lot;
    private String checkPerson;
    private String checkDate;
    private String quatity;
    private String quatityStore;
    private String totalErr;
    private Date createdAt;
    private Date updatedAt;
    private Long workOrderId;
    private String conclude;
    private Integer status;
    private String note;
    private String productionName;
    private String productionCode;
    private String purchaseOrderCode;
    private String groupName;
    private String branchName;
    private String quantityPlan;
    private String sapWo;
    private String lotNumber;
    private String planingWorkOrderCode;
    private String bomVersion;
    private String totalError;
    private String woId;
    private String startTime;
    private String endTime;
    private String quantityStoreSap;
}
