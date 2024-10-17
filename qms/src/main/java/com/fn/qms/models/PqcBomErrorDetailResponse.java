package com.fn.qms.models;

public interface PqcBomErrorDetailResponse {
    String getItemName();

    String getItemCode();

    Integer getId();

    String getErrorCode();

    String getErrorName();

    Integer getQuantity();

    Integer getQuantity2();

    String getCreatedAt();

    String getUpdatedAt();
    String getNote();
    Integer getPqcBomQuantityId();
    Integer getPqcWorkOrderId();
    Integer getPqcBomWorkOrderId();
}
