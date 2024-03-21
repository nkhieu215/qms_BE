package com.fn.qms.rest.pqc;

import com.fn.qms.dto.ReportStoreViewDTO;
import com.fn.qms.models.ReportStoreView;
import com.fn.qms.rest.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReportStoreReponse extends BaseResponse {
    List<ReportStoreViewDTO> lstData;

}
