package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
public class PqcQualityDTO {
    private Long id;
    private String checkPersion;
    private Long workOrderId;
    private String note;
    private String conclude;
    private String quantity;
    private String createdAt;
    private List<PqcQualityCheckDTO> lstCheck;
}
