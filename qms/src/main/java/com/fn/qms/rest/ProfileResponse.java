package com.fn.qms.rest;

import java.util.List;

import com.fn.qms.planning.model.PartNumberDetail;
import com.fn.qms.planning.model.ProgrammingDetail;
import com.fn.qms.rest.bean.FeederPartNumber;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileResponse extends BaseResponse{

   
    public String uProname;
    public String name;
    public int profileCode;
    public String uProno;
    public List<Object> details;
    
    public ProgrammingDetail programming;
    
	
	
    List<PartNumberDetail> lstPartNumber;
    
}
