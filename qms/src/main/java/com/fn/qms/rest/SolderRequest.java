package com.fn.qms.rest;

import com.fn.qms.dto.PqcFixErrDTO;
import com.fn.qms.dto.SolderCheckDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolderRequest extends BaseRequest{
    SolderCheckDTO data;
}
