package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class BomWorkOrderDTO {
    private int id;

    private String bomQuantity;

    private String itemCode;

    private String itemName;

    private String partNumber;

    private String quantity;

    private String vendor;

    private String version;

    private Long workOrderId;

    private String workOrderQuantity;

    private String uitmTech;

    private String ualter;

    private String uremarks;

    private String uctrLevel;

    private String uotherNam;

    private String ulocation;
}
