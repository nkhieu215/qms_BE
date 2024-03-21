package com.fn.qms.rest;

import com.fn.qms.dto.AssemblesSuccessCheckDTO;
import com.fn.qms.dto.MountCheckDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssemblesRequest extends BaseRequest{
    AssemblesSuccessCheckDTO data;
}
