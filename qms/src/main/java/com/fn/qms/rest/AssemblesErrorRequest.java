package com.fn.qms.rest;

import com.fn.qms.dto.AssemblesErrorDTO;
import com.fn.qms.dto.SolderErrorDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssemblesErrorRequest extends BaseRequest{
    AssemblesErrorDTO data;
}
