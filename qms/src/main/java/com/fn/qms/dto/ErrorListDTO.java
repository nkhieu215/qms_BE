package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ErrorListDTO {
    private int id;

    private Long dttdCheckId;

    private String dttdType;

    private String errGroup;

    private String errName;
    private String errCode;
    private String itemCode;

    private int quantity;

    private String ratio;
    private Integer electCompId;
}
