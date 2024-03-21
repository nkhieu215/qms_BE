package com.fn.qms.bean;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

	private String requestId;

    String responseCode;
    String responseMsg;
    
    private Object obj;
    private List<Object> lstObject;
}
