package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.Examination;
import com.fn.qms.command.ExaminationValidator;
import com.fn.qms.command.InsertTransactionLog;

public class ExaminationService  extends ChainBase {

    public ExaminationService() {
        super();       
        addCommand(new  Examination());
    }
}
