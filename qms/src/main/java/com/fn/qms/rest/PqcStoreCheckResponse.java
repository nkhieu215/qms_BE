package com.fn.qms.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PqcStoreCheckResponse {
    private Integer id;
    private String workOrderId;
    private String quantityStore;
    private String conclude;
    private Integer productType;
    private String productionCode;
    private String productionName;
    private String branchName;
    private String groupName;
}
