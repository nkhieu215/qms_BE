package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.ElectronicComponentApprove;

public class ElectronicComponentApproveService  extends ChainBase {

    public ElectronicComponentApproveService() {
        super();      
        
        addCommand(new  ElectronicComponentApprove());
    }
}
