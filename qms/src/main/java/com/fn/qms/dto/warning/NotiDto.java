package com.fn.qms.dto.warning;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotiDto {
    String title;
    String type;
    String topic;
    String appName;
    String content;

}