package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class PqcDrawNvlTestDTO {
    private Long id;

    private String allowResult;

    private String checkDate;

    private String externalInspection;

    private String itemCode;

    private String itemName;

    private String lot;
    private Date manufactureDate;

    private String maxCosfi;

    private String maxElectric;

    private String maxPower;

    private String minCosfi;

    private String minElectric;

    private String minPower;

    private String note;

    private String partNumber;

    private String poCode;

    private String qty;

    private String rankAp;

    private String rankMau;

    private String rankQuang;

    private String realResult;

    private String regulationCheck;

    private String sampleQuantity;

    private String technicalPara;

    private String vendor;

    private Long workOrderId;

    private Long pqcDrawNvlId;

    private String paramMax;

    private String paramMin;

    private String unit;
    private String returnDay;
}
