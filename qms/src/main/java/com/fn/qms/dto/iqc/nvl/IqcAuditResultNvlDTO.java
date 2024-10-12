package com.fn.qms.dto.iqc.nvl;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class IqcAuditResultNvlDTO {

    private Long id;
    private String approveStatus;
    private Long auditCriteriaId;
    private String checkResult;
    private Long electCompId;
    private String itemType;
    private float max;
    private float min;
    private String note;
    private String ortherRequerement;
    private String quantity;
    private String unit;

    private String minAudit;
    private String maxAudit;
    private String unitAudit;
    private String noteAudit;
    private String criteriaName;
    private String regulationLevel;
    private String acceptanceLevel;

}
