package com.fn.qms.rest;

import com.fn.qms.dto.MountCheckDTO;
import com.fn.qms.dto.SolderCheckDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MountRequest extends BaseRequest{
    MountCheckDTO data;
}
