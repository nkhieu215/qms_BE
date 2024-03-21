package com.fn.qms.dto.warning;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IqcWarning {
    String name;
    String url;
    String quantity;
    String date;
    String numberCheck;
    String po;
    String code;
    String conclude;
    String note;
    String grpo;
    String type;
}
