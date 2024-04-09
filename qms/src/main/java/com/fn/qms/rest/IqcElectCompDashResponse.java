package com.fn.qms.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IqcElectCompDashResponse {
    private String origin;
    private String poQuantity;
    private String status;
    private Integer checkingQuantity;
    private String conclusion;
    private String electCompCode;
    private String electCompName;
}
