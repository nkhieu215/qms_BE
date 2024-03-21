package com.fn.qms.planning.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;


@Configuration
@PropertySources({ @PropertySource("classpath:application.properties") })
public class ConfigPlaning {

	@Autowired
	private Environment env; // Contains Properties Load by @PropertySources

	public static String PLAINNING_URL_SERVICE;
	public static String PROFILE_URL_SERVICE;
	public static String SCADA_URL_SERVICE;
	public static String SCADA_URL_CONFIG_SERVICE;
	@PostConstruct
    public void init() {
		
		PLAINNING_URL_SERVICE = env.getProperty("planning.url.service");
		PROFILE_URL_SERVICE = env.getProperty("profile.url.service");
		SCADA_URL_SERVICE = env.getProperty("scada.url.service");
		SCADA_URL_CONFIG_SERVICE = env.getProperty("scada.url.service.config");
    }
}