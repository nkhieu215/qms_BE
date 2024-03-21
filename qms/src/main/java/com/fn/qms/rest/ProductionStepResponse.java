package com.fn.qms.rest;

import java.util.List;

import com.fn.qms.dto.WoDTO;
import com.fn.qms.models.PqcErrorList;
import com.fn.qms.models.PqcWorkOrder;
import com.fn.qms.planning.model.ProductPlanning;
import com.fn.qms.planning.model.UserWorkOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductionStepResponse extends BaseResponse{


	List<ProductPlanning> lstProduct;
	ProductPlanning planning;
	List<UserWorkOrder> lstUserDetail;
	List<PqcWorkOrder> lstOrder;
	WoDTO pqcWorkOrder;

	
}
