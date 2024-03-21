package com.fn.qms.dto.iqc.nvl;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class IqcAuditCriteriaNvlDTO {
    private Long id;

    private Long templateId;

    private String criteriaName;

    private String max;

    private String min;

    private String note;

    private String regulationLevel;

    private String unit;
}
