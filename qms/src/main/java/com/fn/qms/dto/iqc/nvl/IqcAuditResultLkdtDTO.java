package com.fn.qms.dto.iqc.nvl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IqcAuditResultLkdtDTO {
    public Long id;
    public Long templateId;
    public String auditContent;
    public String regulationLevel;
    public String acceptanceLevel;
    public String technicalRequirement;
    public Long auditCritetiaLkdtId;
    public String ids;
    public String quantity;
    public String inaccuracy;
    public String checkContent;
    public String checkResult;
    public String min;
    public String max;
    public String minAudit;
    public String maxAudit;
    public String unit;
}
