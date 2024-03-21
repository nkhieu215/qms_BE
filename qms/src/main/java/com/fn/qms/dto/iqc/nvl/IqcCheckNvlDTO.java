package com.fn.qms.dto.iqc.nvl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IqcCheckNvlDTO {
    public Long id;
    public Long templateId;
    public String criteriaName;
    public String max;
    public String min;
    public String note;
    public String regulationLevel;
    public String unit;
    public String auditCriteriaId;
    public String minAudit;
    public String maxAudit;
    public String noteAd;
    public String unitAudit;
    public String ids;
    public String ortherRequerementAudit;
    public String quantityAudit;
    public String checkResultAudit;
}
