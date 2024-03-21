package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class IqcAuditCriteriaParameterDTO {
    private int id;
    private long templateId;
    private String conditions;
    private Double max;
    private Double min;
    private String parameterName;
    private String unit;
}
