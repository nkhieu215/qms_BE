package com.fn.qms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fn.qms.models.IqcAuditCriteriaParameter;
import com.fn.qms.models.IqcElectronicComponent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class IqcAuditResultParameterDTO {

    private int id;
    private String avg;
    private String checkResult;
    private String content;
    private String kl;
    private String ku;
    private String max;
    private String min;
    private String kmin;
    private String cpk;
    private String cpkLow;
    private String cpkUp;
    private String qAvg;
    private String quantity;
    private String s;
    private String avgResult;
    private Long electCompId;
    private Long parameterId;
    private IqcAuditCriteriaParameterDTO auditCriteriaParam;
}
