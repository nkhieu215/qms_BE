package com.fn.qms.planning.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Machine {
    public int id;
    public String lineId;
    public String machineName;
    public int status;
    public String workCenterId;
}
