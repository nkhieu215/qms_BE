package com.fn.qms.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PqcStoreCheckResponse {
    private Integer id;
    private String workOrderId;
    private String quantityStore;
    private String conclude;
}
