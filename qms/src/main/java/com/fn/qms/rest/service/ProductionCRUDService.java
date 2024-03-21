package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.ProductionCRUDAction;
import com.fn.qms.command.ProductionPlanningAction;


public class ProductionCRUDService  extends ChainBase {
    public ProductionCRUDService() {
        super();      
        addCommand(new  ProductionCRUDAction());
    }
}
