package com.fn.sap.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SapServiceResult {

  private String errcode;

  private String appId;

  private String opstatus;

  private String errmsg;
}
