package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PqcApproveDTO {
    private String checkPerson;
    private Long workOrderId;
    private String note;
    private String conclude;
    private List<StepStatusDTO> lstStep;
    private String type;

}
