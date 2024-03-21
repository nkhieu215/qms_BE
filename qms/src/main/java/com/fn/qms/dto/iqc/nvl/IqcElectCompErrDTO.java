package com.fn.qms.dto.iqc.nvl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IqcElectCompErrDTO {
    Long id;
    String errGroup;
    String errName;
    String note;
    String quantity;
    String ratio;
    String electCompId;
}
