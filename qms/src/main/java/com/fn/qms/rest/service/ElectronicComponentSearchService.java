package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.ElectronicComponentSearch;

public class ElectronicComponentSearchService  extends ChainBase {

    public ElectronicComponentSearchService() {
        super();      
        
        addCommand(new  ElectronicComponentSearch());
    }
}
