package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PqcPhotoelectricProductDTO {
    private int id;

    private String checkPerson;

    private String coefficientWattageMax;

    private String coefficientWattageMin;

    private String colorMax;

    private String colorMin;

    private String colorTempMax;

    private String colorTempMin;

    private String conclude;

    private Date createdAt;

    private String ectricMax;

    private String ectricMin;

    private String note;

    private String performanceMax;

    private String performanceMin;

    private String pow;

    private String powMax;

    private String powMin;

    private String quatity;

    private String ratio;

    private String tbn;

    private String temp;

    private Date updatedAt;

    private String wattageMax;

    private String wattageMin;

    private String lotNumber;
    private String sdcmMax;
    private String sdcmMin;
    private String powSupplyMax;
    private String powSupplyMin;
    private Long workOrderId;
}
