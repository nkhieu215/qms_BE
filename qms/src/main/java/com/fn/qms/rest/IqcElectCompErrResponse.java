package com.fn.qms.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IqcElectCompErrResponse {
    private String errName;
    private Integer quantity;
    private Integer checkingQuantity;
    private String electCompCode;
    private String electCompName;
}