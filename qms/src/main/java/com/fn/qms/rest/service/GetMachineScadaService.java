package com.fn.qms.rest.service;

import com.fn.qms.command.GetMachineCommand;
import com.fn.qms.command.GetStepProcess;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GetMachineScadaService extends ChainBase {

    @Autowired
    GetMachineCommand getMachineCommand;

    @PostConstruct
    public void addCommandChain() {

        addCommand(getMachineCommand);
    }
}
