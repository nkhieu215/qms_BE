package com.fn.qms.rest;

import com.fn.qms.dto.SolderCheckDTO;
import com.fn.qms.dto.SolderErrorDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolderErrorRequest extends BaseRequest{
    SolderErrorDTO data;
}
