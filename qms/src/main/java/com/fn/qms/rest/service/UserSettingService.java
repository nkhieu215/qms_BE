package com.fn.qms.rest.service;

import org.apache.commons.chain.impl.ChainBase;

import com.fn.qms.command.GetSettingByUser;

public class UserSettingService extends ChainBase{

	public UserSettingService() {
        super();
        addCommand(new GetSettingByUser());
	}	
}
