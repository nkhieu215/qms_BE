package com.fn.qms.planning.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;


@Configuration
@PropertySources({ @PropertySource("classpath:application.properties") })
public class ConfigSSO {

	@Autowired
	private Environment env; // Contains Properties Load by @PropertySources

	public static String SSO_URL;
	public static String SSO_REALM;
	public static String SSO_USER;
	public static String SSO_PASS;
	public static String CLIENT_ID;
	public static String CLIENT_SECRET;
	@PostConstruct
    public void init() {
		
		SSO_URL = env.getProperty("sso.url");
		SSO_REALM = env.getProperty("sso.realm");
		SSO_USER = env.getProperty("sso.user");
		SSO_PASS = env.getProperty("sso.pass");
		CLIENT_ID = env.getProperty("sso.clientid");
		CLIENT_SECRET= env.getProperty("sso.secret");
		
    }
}