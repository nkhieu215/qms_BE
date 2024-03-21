package com.fn.qms.rest;

import com.fn.qms.dto.PqcFixErrDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PqcFixErrRequest  extends BaseRequest{
    PqcFixErrDTO data;
    String type;
}
