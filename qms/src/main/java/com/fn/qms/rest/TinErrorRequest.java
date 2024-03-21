package com.fn.qms.rest;

import com.fn.qms.dto.AssemblesErrorDTO;
import com.fn.qms.dto.TinErrorDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TinErrorRequest extends BaseRequest{
    TinErrorDTO data;
}
