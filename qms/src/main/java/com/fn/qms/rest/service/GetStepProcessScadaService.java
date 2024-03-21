package com.fn.qms.rest.service;

import com.fn.qms.command.EmployeeAction;
import com.fn.qms.command.GetStepProcess;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GetStepProcessScadaService extends ChainBase {

    @Autowired
    GetStepProcess  getStepProcess;

    @PostConstruct
    public void addCommandChain() {

        addCommand(getStepProcess);
    }
}
