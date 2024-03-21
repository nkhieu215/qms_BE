package com.fn.qms.dto;

import java.util.List;

import com.fn.qms.planning.model.UserWorkOrder;
import com.fn.qms.rest.bean.WorkOder;
import com.fn.sap.modelsbak.Citt1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WoCreateDTO {	
	private WorkOder data;
	private List<Citt1> bomversion;	
	private List<UserWorkOrder> lstUserDetail;
	
}
