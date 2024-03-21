package com.fn.planing.rest;

import com.fn.planing.dto.Dnlnvl;
import com.fn.qms.rest.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class DnlNvlResponse extends BaseResponse {
    public String woId;
    public String sapWo;
    public String numOfReq;
    public String lotNumber;
    public Object profileId;
    public Object profileCode;
    public Object profileName;
    public ArrayList<Dnlnvl> dnlnvl;
}
