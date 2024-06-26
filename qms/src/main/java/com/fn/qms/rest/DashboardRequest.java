package com.fn.qms.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DashboardRequest {
    private String startDate;
    private String endDate;
    private String productCode;
    private String productName;
    private String branchName;
    private String groupName;
}
