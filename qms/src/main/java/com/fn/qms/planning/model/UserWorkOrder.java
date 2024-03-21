package com.fn.qms.planning.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserWorkOrder {

	public String userId;
    public String id;
    public String workOrder;
    public String stageName;
    public String stageCode;
    public int status;
    public String userName;
}
