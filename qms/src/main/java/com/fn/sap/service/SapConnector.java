package com.fn.sap.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.utils.AppLog;
import com.fn.sap.dto.ApproveStoreSapResponse;
import com.fn.sap.dto.SendSapRequest;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@ConditionalOnProperty(name = "sap.service.host", havingValue = "")
public class SapConnector {
    @Autowired
    SapClient sapClient;

    @Value("${sap.service.host}")
    String baseUrl;
    public String sendApproveStore(SendSapRequest request)  throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String requestJson = mapper.writeValueAsString(request);
        AppLog.info("send to sap request: {}," + requestJson);
//        ApproveStoreSapResponse response = sapClient.sendApproveStore(request);

        RestTemplate restTemplate = new RestTemplate();

        String url = baseUrl + "/api/PostReceiptFromPanacim";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
        System.out.println(answer);
        return answer;
    }
}
