package com.fn.qms.rest;

import com.fn.qms.dto.PqcFixErrDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScadaRequest extends BaseRequest{
    String woId;
    String type;
    String sadaId;
}
