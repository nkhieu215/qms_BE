package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.ProductionPlanningAction;

public class ProductionPlaningService  extends ChainBase {

    public ProductionPlaningService() {
        super();      
        addCommand(new  ProductionPlanningAction());
    }
}
