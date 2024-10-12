package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PqcCriteriaQualityDTO {
    private Long id;
    private Long templateId;
    private String auditContent;
    private String regulationLevel;
    private String acceptanceLevel;
    private String technicalRequirement;

}
