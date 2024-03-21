package com.fn.qms.planning.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPlanning {

	public String id;
    public String woId;
    public String line;
    public int planningWorkOrderId;
    public String productOrder;
    public String productName;
    public String bomVersion;
    public String productCode;
    public Date createTime;
    public int quantityPlan;
    public Date startTime;
    public Date endTime;
    public String lotNumber;
    public String branchCode;
    public String groupName;
    public String groupCode;
    public String branchName;
    public String profileName;
    public String profile;
    public String sapWo;
    public String lineName;
}
