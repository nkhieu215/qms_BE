package com.fn.qms.rest;

import java.util.List;

import com.fn.qms.models.PqcWorkOrderPlanning;

import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
public class PlanningRequest extends BaseRequest{
    private List<PqcWorkOrderPlanning> data;
}
