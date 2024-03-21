package com.fn.qms.rest.service;

import com.fn.qms.command.PqcFixError;
import com.fn.qms.command.ScadaAssetByName;
import com.fn.qms.command.ScadaGetMachine;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ScadaMachineService extends ChainBase {

    @Autowired
    ScadaGetMachine scadaGetMachine;


    @Autowired
    ScadaAssetByName scadaAssetByName;

    @PostConstruct
    public void addCommandChain() {
        addCommand(scadaAssetByName);
        addCommand(scadaGetMachine);
    }
}
