package com.fn.qms.rest;

import com.fn.qms.dto.PqcApproveDTO;
import com.fn.qms.dto.PqcQualityDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class PqcApproveRequest extends BaseRequest{

    PqcApproveDTO data;
}
