package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.InsertTransactionLog;
import org.springframework.stereotype.Service;

@Service
public class TransactionLogService extends ChainBase {

    public TransactionLogService() {
        super();
        addCommand(new InsertTransactionLog());
    }
}
