package com.fn.qms.service.api.base;

import com.fn.qms.constant.Constant;

public enum ApiConstantUrl {
	EXECUTE_T24_ROUTINE("/t24-query/v1.0/routine", Constant.POST, "execute t24 routine"),
    GET_T24_CUST_INFO("/customer/v1.0/", Constant.GET, "get t24 customer information"),
    GET_OTP_SHARE("/otpshare/v1.0/getOtpShare", Constant.GET, "get otp share")
	;
	
	 private ApiConstantUrl(String url, String method, String desc, Boolean isparam) {
	        this.url = url;
	        this.desc = desc;
	        this.method = method;
	        this.isparam = isparam;
	    }

	    private ApiConstantUrl(String url, String method, String desc) {
	        this.url = url;
	        this.desc = desc;
	        this.method = method;
	    }

	    private ApiConstantUrl(String url, String method, String desc, String host) {
	        this.url = url;
	        this.desc = desc;
	        this.method = method;
	        this.host = host;
	    }

	   
	    public Boolean getIsparam() {
	        return isparam;
	    }

	   
	    public String getUrl() {
	        return url;
	    }

	    public String getDesc() {
	        return desc;
	    }

	   
	    public String getMethod() {
	        return method;
	    }

	    private String url;
	    private String desc;
	    private String method;
	    private String host;
	    private Boolean isparam = false;

	  
	    public String getHost() {
	        return host;
	    }
}
