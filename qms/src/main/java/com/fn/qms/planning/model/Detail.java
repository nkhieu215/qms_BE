package com.fn.qms.planning.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Detail {
	public String id;
    public String machineCode;
    public PartNumber partNumber;
    public SubPartNumber subPartNumber;
}
