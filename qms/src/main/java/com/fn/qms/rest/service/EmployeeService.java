package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.EmployeeAction;

public class EmployeeService  extends ChainBase {

    public EmployeeService() {
        super();      
        addCommand(new  EmployeeAction());
    }
}
