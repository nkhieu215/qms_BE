package com.fn.qms.dto;

import com.fn.qms.models.PqcPhotoelectricLkdt;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PqcPhotoelectricDTO {
    private Long id;
    private String conclude;
    private Date createdAt;
    private String lot;
    private String note;
    private Date updatedAt;
    private Long workOrderId;
    private String quantity;
    private String createdBy;
    List<PqcPhotoelectricLkdtDTO> lstLkdt;
    List<PqcPhotoelectricParamDTO> lstParam;
}
