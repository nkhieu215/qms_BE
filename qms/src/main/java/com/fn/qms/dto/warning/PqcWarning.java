package com.fn.qms.dto.warning;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PqcWarning {
    String wo;
    String productName;
    String productCode;
    String lotnumber;
    String dateStart;
    String poCode;
    String step;
    String note;
    String url;
    String conclude;
}
