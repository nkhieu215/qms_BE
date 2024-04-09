package com.fn.qms.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PqcPhotoElectDashResponse {
    private String quantity;
    private String conclude;
    private String productionCode;
    private String productionName;
    private String branchName;
    private String groupName;
}
