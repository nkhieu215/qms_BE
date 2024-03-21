package com.fn.qms.rest.service;

import com.fn.qms.command.LineAction;
import com.fn.qms.command.SapAction;
import org.apache.commons.chain.impl.ChainBase;

public class LineService extends ChainBase {

    public LineService() {
        super();      
        addCommand(new LineAction());
    }
}
