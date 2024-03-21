package com.fn.qms.bean;
import java.util.HashMap;

import org.apache.commons.chain.impl.ContextBase;
import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.security.services.UserDetailsImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessContext extends ContextBase {
	
	Request request;
    Response response;
    UserDetailsImpl user;
    Validator.Result result;
    //cac bien phat sinh
    HashMap<String, Object> varRef;
    
    ApplicationContext context;
    
    public ProcessContext() {
        this.varRef = new HashMap<String, Object>();
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

  

    public Validator.Result getResult() {
        return result;
    }

    public void setResult(Validator.Result result) {
        this.result = result;
        if (this.response != null) {
            this.response.setResponseCode(result.getResponseCode());
        }
    }

    public Request getRequest() {
        return request;
    }

    public void putVar(String key, Object value) {
        if (varRef.containsKey(key)) {
            varRef.remove(key);
        }
        varRef.put(key, value);
    }

    public Object getVar(String key) {
        if (varRef.containsKey(key)) {
            return varRef.get(key);
        }
        return null;
    }
}
