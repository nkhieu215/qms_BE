package com.fn.qms.dto.warning;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Scan100Warning {
    private String machine;
    private String workOrder;
    private Boolean status;
}
