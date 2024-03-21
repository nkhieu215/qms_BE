package com.fn.qms.config;

import com.fn.qms.process.WarningProcess;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class StartProcess {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	ThreadRunConfig threadRunConfig;
	@PostConstruct
	public void startProcess() {
		for (int i = 0; i < threadRunConfig.warning; i++) {
			WarningProcess sync = new WarningProcess(applicationContext);
			sync.start();
		}
	}


}
