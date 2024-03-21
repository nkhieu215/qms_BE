package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.ErrorAction;
import com.fn.qms.command.Examination;
import com.fn.qms.command.ExaminationValidator;
import com.fn.qms.command.InsertTransactionLog;
import com.fn.qms.command.OitmAction;

public class ErrorCrudService  extends ChainBase {

    public ErrorCrudService() {
        super();      
        addCommand(new  ErrorAction());
    }
}
