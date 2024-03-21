package com.fn.qms.rest.service;

import com.fn.qms.command.LineAction;
import com.fn.qms.command.MachineAction;
import org.apache.commons.chain.impl.ChainBase;

public class MachineService extends ChainBase {

    public MachineService() {
        super();      
        addCommand(new MachineAction());
    }
}
