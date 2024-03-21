package com.fn.qms.rest;

import com.fn.qms.dto.PqcQualityDTO;
import com.fn.qms.dto.ReportErrorAllDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReportErrorResponse extends BaseResponse{
   List<ReportErrorAllDTO> reportError;
}
