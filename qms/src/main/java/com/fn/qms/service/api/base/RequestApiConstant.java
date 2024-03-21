package com.fn.qms.service.api.base;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
    @PropertySource("classpath:application.properties")})
public class RequestApiConstant {
	@Autowired
    private Environment env; // Contains Properties Load by @PropertySources
	
    public static String AUTHEN_TOKEN_URL;
    public static String API_COMMON_URL;
    

    @PostConstruct
    public void init() {
        AUTHEN_TOKEN_URL = env.getProperty("api.authen.url");
        API_COMMON_URL = env.getProperty("api.common.url");
    }
}
