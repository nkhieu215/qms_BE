package com.fn.sap.service;

import com.fn.sap.dto.ApproveStoreSapResponse;
import com.fn.sap.dto.SendSapRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@FeignClient(name = "SapRequestService", url = "${sap.service.host}", configuration = {
    SSLSapConfiguration.class, SapClientDecoder.class})
public interface SapClient {

  @PostMapping(value = "/api/PostReceiptFromPanacim", consumes= MediaType.APPLICATION_JSON_VALUE)
  ApproveStoreSapResponse sendApproveStore(  @RequestBody SendSapRequest request) throws IOException;

}
