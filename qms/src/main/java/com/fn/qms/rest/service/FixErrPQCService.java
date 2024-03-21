package com.fn.qms.rest.service;

import com.fn.qms.command.Examination;
import com.fn.qms.command.PqcFixError;
import com.fn.qms.models.PqcFixErr;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class FixErrPQCService extends ChainBase {

    @Autowired
    PqcFixError pqcFixErr;

    @PostConstruct
    public void addCommandChain() {
        addCommand(pqcFixErr);
    }
}
