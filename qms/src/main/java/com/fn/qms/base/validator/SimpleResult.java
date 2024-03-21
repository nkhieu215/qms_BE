package com.fn.qms.base.validator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fn.qms.base.validator.Validator.Result;

public class SimpleResult implements Result {

    boolean result;
    String message;
    String responseCode;
    @JsonIgnore
    String clearMessage;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    public SimpleResult(String message, boolean result, String responseCode) {
        this.result = result;
        this.message = message;
        this.responseCode = responseCode;
    }
    
    public SimpleResult(String message, boolean result, String responseCode, String clearMessage) {
        this.result = result;
        this.message = message;
        this.responseCode = responseCode;
        this.clearMessage = clearMessage;
    }
    
    @Override
    @JsonIgnore
    public String getClearMessage() {
        return clearMessage;
    }

    @Override
    public boolean isOk() {
        return result;
    }

    @Override
    public String getResponseCode() {
        return responseCode;
    }
}
