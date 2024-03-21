package com.fn.qms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
@PropertySources({ @PropertySource("classpath:application.properties")})
public class StoreImageConfig {
    @Autowired
    private Environment env; // Contains Properties Load by @PropertySources

    public static String PATH = "";

    @PostConstruct
    public void init() {
        PATH = env.getProperty("upload.image");


    }
}
