package com.fn.sap.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendSapRequest{
    @JsonProperty("WoId")
    public String woId;
    @JsonProperty("SapWo")
    public String sapWo;
    public String numOfReq;
    @JsonProperty("LotNumber")
    public String lotNumber;
    @JsonProperty("ProfileId")
    public String profileId;
    @JsonProperty("ProfileCode")
    public String profileCode;
    @JsonProperty("CreatedAt")
    public String createdAt;
    @JsonProperty("TransactionType")
    public String transactionType;
    @JsonProperty("From")
    public String from;
    @JsonProperty("To")
    public String to;
    @JsonProperty("SourceDepartment")
    public String sourceDepartment;
    @JsonProperty("DestinationDepartment")
    public String destinationDepartment;
    @JsonProperty("WareHouse")
    public String wareHouse;

    @JsonProperty("Note")
    public String note;
    @JsonProperty("ItemInfor")
    public ArrayList<ItemInfor> itemInfor;
}
