package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.ElectronicComponentCRUD;

public class ElectronicComponentService  extends ChainBase {

    public ElectronicComponentService() {
        super();      
        
        addCommand(new  ElectronicComponentCRUD());
    }
}
