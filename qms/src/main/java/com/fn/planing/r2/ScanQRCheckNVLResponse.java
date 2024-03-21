package com.fn.planing.r2;

import com.fn.qms.rest.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ScanQRCheckNVLResponse extends BaseResponse {
    public String woId;
    public String sapWo;
    public String numOfReq;
    public String lotNumber;
    public String profileId;
    public String profileCode;
    public String profileName;
    public ArrayList<Dnlnvl> dnlnvl;
}
