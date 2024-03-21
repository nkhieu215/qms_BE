package com.fn.qms.rest.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class IqcSearchParam {
    String code;
    String endDate;
    String iqcCode;
    String itemType;
    String name;
    String reportCode;
    String type;
    String startDate;
    String status;
    String invoiceNumber;
}
