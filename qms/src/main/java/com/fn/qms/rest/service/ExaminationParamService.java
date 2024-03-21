package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.ExaminationParam;

public class ExaminationParamService  extends ChainBase {

    public ExaminationParamService() {
        super();              
        addCommand(new  ExaminationParam());
    }
}
