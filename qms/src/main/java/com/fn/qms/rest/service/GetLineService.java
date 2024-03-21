package com.fn.qms.rest.service;

import com.fn.qms.command.GetLineCommand;
import com.fn.qms.command.GetMachineCommand;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GetLineService extends ChainBase {

    @Autowired
    GetLineCommand getLineCommand;

    @PostConstruct
    public void addCommandChain() {

        addCommand(getLineCommand);
    }
}
