package com.fn.qms.dto.iqc.nvl;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class IqcAuditResultParameterDTO {
    public Long id;
    public Long templateId;
    public String conditions;
    public String max;
    public String min;
    public String parameterName;
    public String unit;
    public Long parameterId;
    public String ids;
    public String minAudit;
    public String maxAudit;
    public String avgResult;
    public ArrayList<String> data;
    public String s;
    public String quantity;
    public String ku;
    public String kl;
    public String cpkUp;
    public String cpkLow;
    public String checkResult;
    public String kmin;
    public String cpk;
    public String content;
    public String QAvg;

}
