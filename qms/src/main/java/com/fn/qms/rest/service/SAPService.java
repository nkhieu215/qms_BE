package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.OitmAction;
import com.fn.qms.command.SapAction;

public class SAPService  extends ChainBase {

    public SAPService() {
        super();      
        addCommand(new  SapAction());
    }
}
