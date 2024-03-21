package com.fn.qms.rest;

import com.fn.qms.models.PqcWorkOrder;
import com.fn.qms.planning.model.PlanningPermission;
import com.fn.qms.planning.model.ProductPlanning;
import com.fn.qms.planning.model.UserWorkOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetPermissionsResponse extends BaseResponse{


	List<PlanningPermission> entities;

}
