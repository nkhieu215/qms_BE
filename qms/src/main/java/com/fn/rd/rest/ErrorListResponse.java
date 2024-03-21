package com.fn.rd.rest;

import com.fn.qms.rest.BaseResponse;
import com.fn.rd.dto.ErrorDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorListResponse extends BaseResponse {
    private ErrorDTO error;
    private List<Error> data;
}
