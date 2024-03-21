package com.fn.qms.rest.service;

import com.fn.qms.command.ErrorAction;
import com.fn.qms.command.GetErrorCommon;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ErrorCommonService extends ChainBase {

    @Autowired
    GetErrorCommon getErrorCommon;

    @PostConstruct
    public void addCommandChain() {
        addCommand(getErrorCommon);
    }
}
