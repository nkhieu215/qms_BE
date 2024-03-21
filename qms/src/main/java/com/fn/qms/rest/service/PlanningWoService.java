package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.OitmAction;
import com.fn.qms.command.PlanningWoAction;
import com.fn.qms.command.SapAction;

public class PlanningWoService  extends ChainBase {

    public PlanningWoService() {
        super();      
        addCommand(new  PlanningWoAction());
    }
}
