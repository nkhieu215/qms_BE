package com.fn.qms.rest;

import com.fn.qms.dto.AssemblesSuccessCheckDTO;
import com.fn.qms.dto.Scan100DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Scan100Request extends BaseRequest{
    Scan100DTO data;
}
