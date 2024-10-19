package com.fn.qms.dto.iqc.nvl;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class IqcAuditCriteriaLkdtDTO {
    private Long id;
    private long templateId;
    private String auditContent;
    private String regulationLevel;
    private String acceptanceLevel;
    private String technicalRequirement;
    private String min;
    private String max;
    private String unit;
}
