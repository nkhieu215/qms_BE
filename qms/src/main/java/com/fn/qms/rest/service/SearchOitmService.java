package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.SearchOitm;

public class SearchOitmService  extends ChainBase {

    public SearchOitmService() {
        super();      	
        addCommand(new  SearchOitm());
    }
}
