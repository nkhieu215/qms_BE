package com.fn.qms.models;

import javax.validation.constraints.Null;

public interface QrFeederResponse {
    Integer getQrFeederId();
    String getQrFeederCode();
    String getStatus();
    String getCheckType();
}
