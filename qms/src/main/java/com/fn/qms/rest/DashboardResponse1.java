package com.fn.qms.rest;

import com.fn.qms.models.IqcElectCompErr;
import com.fn.qms.models.IqcElectronicComponent;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
// * New dashboard
@Getter
@Setter
public class DashboardResponse1 extends BaseResponse {
    List<IqcElectCompErr> lstIqcElectCompErr;//Tổng lỗi
    List<IqcElectronicComponent> lstIqcElectronicComponents;//Iqc
}
